package Module_C;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Menu_Ordering {
    OrderStack order = new OrderStack();
    OrderStack stack;
    Scanner scanner = new Scanner(System.in);
    
    public Menu_Ordering(){
        
    }
    
    public void classMenu(){
        int orderMore;
        int option;
        String newLineEater;
        
        do {
            orderMore = 0;
            do {
                System.out.println("Food ordering");
                System.out.println("---------------");
                System.out.println("1. Make order");
                if (order.length != -1){
                    System.out.println("2. Check order & confirm order");
                }
                System.out.println("3. Exit without ordering");
                option = scanner.nextInt();
                newLineEater = scanner.nextLine();
                
                if (option == 1){
                    displayRestaurant_Order();
                }
                if (order.length != -1){
                    if (option == 2){
                        displayItems();
                    }
                }
                
            }while (option != 3);
            
            
        }while (orderMore == 1);
        
    }
    public void displayRestaurant_Order(){
        String orderID;
        OrderData initiate = new OrderData();
        orderID = initiate.generateOrderID();
        
        order(orderID);
    }
    public void order(String orderID){
        int restaurantNumber;   //Stores restaurant selected by user 
        String newLineEater;    //Eats new lines for breakfast
        
        try {
            int restaurantCount = 1;
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement pstmtRestaurant = conn.prepareStatement("Select RestaurantName from Menu group by restaurantName");
            ResultSet resultCount = pstmtRestaurant.executeQuery();
            
            if (resultCount.next()== true){
                for (;resultCount.next();restaurantCount++){
                    
                }
            }
            //Displaying dynamic restaurant name
            ResultSet resultSearch = pstmtRestaurant.executeQuery();
            String[] availableRestaurants = new String[restaurantCount];
            int index;
            for(index = 0;resultSearch.next() == true;index++){
                availableRestaurants[index] = resultSearch.getString("RestaurantName");
            }
            System.out.println("Select a restaurant from the list below");
            for(int counter = 0; counter < index; counter++){
                System.out.println((counter+1)+". "+availableRestaurants[counter]);
            }
            restaurantNumber = scanner.nextInt();
            newLineEater = scanner.nextLine();
            restaurantNumber = restaurantNumber - 1;
            
            //Displaying dynamic item data
            PreparedStatement pstmtRestaurantMenu = conn.prepareStatement("Select * from menu where restaurantName = ? and status = 'true'");
            pstmtRestaurantMenu.setString(1, availableRestaurants[restaurantNumber]);
            ResultSet MenuSearchResult = pstmtRestaurantMenu.executeQuery();
            int itemCount = 1;
            if (MenuSearchResult.next()== true){
                for (;MenuSearchResult.next();itemCount++){
                    
                }
            }
            MenuData[] data = new MenuData[itemCount];
            MenuSearchResult = pstmtRestaurantMenu.executeQuery();
            
            
            for(index = 0; MenuSearchResult.next()==true;index++){
                data[index] = new MenuData(MenuSearchResult.getString("ID"), MenuSearchResult.getString("Name"), MenuSearchResult.getDouble("Price"), MenuSearchResult.getBoolean("Status"), MenuSearchResult.getString("RestaurantName"),MenuSearchResult.getDouble("Discount"));
            }
            
            int more = 0;
            do {
                int itemToAdd;
                System.out.println("----------------------------------------------------------------------");
                System.out.printf("%-7s|%-50s|%-7s|%-15s\n", "Index", "Item Name", "Price", "Discount Rate");
                for (int counter = 0; counter < index; counter++){
                    System.out.printf("%-7d|%-50s|%-7.2f|%-15.2f\n", counter+1, data[counter].getName(), data[counter].getPrice(), data[counter].getDiscount());
                }
                
                //data[counter].getName(), data[counter].getPrice(), data[counter].getDiscount()
                System.out.print("Choose an item index to add to cart :");
                itemToAdd = scanner.nextInt();
                newLineEater = scanner.nextLine();
                
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                newLineEater = scanner.nextLine();
                
                //
                int length;
                stack = new OrderStack();
                
                if (order.length+1 > 0){ 
                    length = order.length+1;
                    OrderData[] comparisonData = new OrderData[length];
                    int oldQuantity = 0;
                    int itemIndex = 0;
                    int foundResult = 0;
                    
                    for (int count = 0; count < length; count++){
                        comparisonData[count] = (OrderData)order.pop();
                        stack.push((OrderData)comparisonData[count]);
                        if (data[itemToAdd-1].getID().equals(comparisonData[count].getItemID())){
                            System.out.println("Exiting item has been ordered, adding the new order into the old quantity");
                            oldQuantity = comparisonData[count].getQuantity();
                            quantity = quantity + oldQuantity;
                            itemIndex = count;
                            foundResult = 1;
                        }
                    }
                    order = stack;
                    if (foundResult == 1){
                        order.removeSelected(itemIndex);
                    }
                }
                
                
                //
                
                try {
                    OrderData entry = new OrderData(orderID, data[itemToAdd-1].getID(), data[itemToAdd-1].getName(), data[itemToAdd-1].getPrice(), quantity, data[itemToAdd-1].getResturantName(), data[itemToAdd-1].getDiscount());
                    order.push(entry);
                }
                catch(Exception ex){
                    System.err.println("Enter index as shown in table");
                }
                System.out.print("Enter 1 to add more items to the list: ");
                more = scanner.nextInt();
                newLineEater = scanner.nextLine();
            }while (more == 1);
        }
        catch (SQLException ex){
            System.err.println("SQL Exception");
        }
    }
    public void displayItems(){
        //Manipulation
        int option = 0; //Stores direct user input
        String newLineEater; //Removes excess newline
        
        //Generate a duplicate stack for editing
        int ItemCount = order.length+1;
        OrderStack temp = new OrderStack();
        
        //Peek for restaurant name
        OrderData peekResult = (OrderData)order.peek();
        String restaurantName = peekResult.getRestaurantName();
        
        do{
            if (order.length != -1){
                OrderData[] data = new OrderData[order.length+1];
                
                System.out.println("Selected Restaurant: "+restaurantName);
                System.out.println("---------------------------------");
                System.out.println("Your ordered items: ");
                System.out.printf("%-3s | %-11s | %-30s | %-10s | %-10s | %-10s\n", "No","Item ID", "Item Name", "Item Price", "Quantity", "Total Unit Price");
                for (int index = 0; index < ItemCount; index++){
                    data[index] = (OrderData)order.pop();
                    temp.push((OrderData)data[index]);
                    System.out.printf("%-3d | %-11s | %-30s | %-10.2f | %-10d | %-10.2f\n", index+1, data[index].getOrderID(), data[index].getItemName(), data[index].getUnitPrice(), data[index].getQuantity(), data[index].getTotalUnitPrice());
                }
                System.out.println("Select an option below: ");
                System.out.println("1. Add items");
                System.out.println("2. Remove items");
                System.out.println("3. Confirm order");
                option = scanner.nextInt();
                if (option == 1){
                    order(peekResult.getOrderID());
                }
                else if (option == 2){
                    System.out.print("Select an item to remove: ");
                    int index = scanner.nextInt();
                    order.removeSelected(index-1);
                    newLineEater = scanner.nextLine();
                }
                else if (option == 3){
                    OrderData updateDB = new OrderData();
                    order = temp;
                    updateDB.insertNewOrder(order);
                    
                    System.out.println("Order placed, thank you for your patronage");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
            }
        }while (option != 3);
    }
}
