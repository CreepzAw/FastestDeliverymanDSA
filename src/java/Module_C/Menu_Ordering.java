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
                
                boolean condition = false; //stores value of whether item matches in check
                stack = new OrderStack();
                try {
                    //If true, means order stack has at least 1 record
                    int length = order.length+1;
                    if (length > 0){
                        OrderData[] record = new OrderData[length];
                        for (int start = 0; start < length; start++){
                            record[start] = (OrderData)order.pop();
                            if (record[start].getItemID().equals(data[itemToAdd-1].getID())){
                                int newQuantity = record[start].getQuantity() + quantity;
                                record[start].setQuantity(newQuantity);
                                
                                condition = true;
                            }
                            else {
                                condition = false;
                            }
                            stack.push(record[start]);
                        }
                        order = stack;
                    }
                    if (condition != true)
                    {
                        OrderData entry = new OrderData(orderID, data[itemToAdd-1].getID(), data[itemToAdd-1].getName(), data[itemToAdd-1].getPrice(), quantity, data[itemToAdd-1].getResturantName(), data[itemToAdd-1].getDiscount());
                        order.push(entry);
                    }
                    
                }
                catch(Exception ex){
                    System.err.println(ex);
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
        int ItemCount;
        OrderStack temp = new OrderStack();
        
        //Peek for restaurant name
        OrderData peekResult = (OrderData)order.peek();
        String restaurantName = peekResult.getRestaurantName();
        
        do{
            ItemCount = order.length+1;
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
                order = temp;
                System.out.println("Select an option below: ");
                System.out.println("1. Add items");
                System.out.println("2. Remove items");
                System.out.println("3. Confirm order");
                option = scanner.nextInt();
                newLineEater = scanner.nextLine();
                if (option == 1){
                    order(peekResult.getOrderID());
                }
                else if (option == 2){
                    System.out.print("Select an item to remove: ");
                    int index = scanner.nextInt();
                    
                    stack = new OrderStack();
                    try {
                    //If true, means order stack has at least 1 record
                        int length = order.length+1;
                        if (length > 0){
                            OrderData[] record = new OrderData[length];
                            for (int start = 0; start < length; start++){
                                record[start] = (OrderData)order.pop();
                                if (record[start].getItemID().equals(data[index-1].getItemID())){
                                    
                                }
                                else {
                                    stack.push(record[start]);
                                }
                            }
                        order = stack;
                        }
                    }
                    catch (Exception ex){
                            System.out.println("Error");
                    }
                    
                    newLineEater = scanner.nextLine();
                }
                else if (option == 3){
                    //Insert customer info
                    customerInformation(data[0].getOrderID());
                    
                    OrderData updateDB = new OrderData();
                    order = temp;
                    updateDB.insertNewOrder(order);
                    
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Order placed, thank you for your patronage");
                }
            }
        }while (option != 3);
    }
    
    public void customerInformation(String orderID){
        CustomerDeliveryInfo info = new CustomerDeliveryInfo();
        System.out.println("Thank you for using FastestDeliveryman");
        System.out.println("--------------------------------------");
        System.out.println("Please fill in the details below to confirm your order");
        System.out.print("Enter your name: ");
        info.setName(scanner.nextLine());
        
        System.out.print("Enter the delivery address: ");
        info.setAddress(scanner.nextLine());
        
        String contactNumber;
        boolean invalid;
        do{
            invalid = false;
            System.out.print("Please enter a contact  number in the format (xxx-xxxxxxx): ");
            contactNumber = scanner.nextLine();
            if (contactNumber.length() != 11){
                invalid = true;
                System.err.println("Invalid contact number, try again\n");
            }
        }while (invalid == true);
        String firstThree = contactNumber.substring(0, 3);
        String lastSegment = contactNumber.substring(4);
        info.setContactNumber(firstThree.concat(lastSegment));
        
        info.setOrderID(orderID);
        info.setDelivered(false);
        
        info.addIntoLocalDatabase();
    }
}
