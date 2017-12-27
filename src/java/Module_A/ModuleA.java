/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_A;

import Module_C.*;

import java.util.Scanner;

/**
 *
 * @author Greyson
 */
public class ModuleA {
    MyList<Menu> list = new MyList();
    Scanner scanner = new Scanner(System.in);
    String restaurantName="";
    
    public ModuleA(){
        mainMenu();
  }
    public void addItem(){
        String productId="";
         String name="";
         double price;
         char choice ='Y';
         boolean status = true;
         char available='Y';
         double discountRate =0.0;
         
         do{
        System.out.println();
        System.out.println("Enter Product ID: ");       
        productId = scanner.nextLine();
        System.out.println(""); 
        System.out.println("Enter Product Name: ");       
        name = scanner.nextLine();
        System.out.println("");
        System.out.println("Enter Product Price : ");
        price = scanner.nextDouble();
   
        System.out.println("Available Now ? (Y/N)");
        available=scanner.next().charAt(0);
        
        System.out.println("Enter Discount Rate : ");
        discountRate = scanner.nextDouble();
        
        if(available=='Y' || available =='y'){
            status=true;
        }else{
            status=false;
        }
        
        System.out.println("");
        System.out.println("Continue? (Y/N)");
        choice= scanner.next().charAt(0);
        scanner.nextLine();
        System.out.println("\n------------------------------------------------------------\n");
        
       
        Menu menu = new Menu(productId,name,price,restaurantName,status,discountRate);
        
        //Insert into database
        MenuData insert = new MenuData();
        insert.addLocalDatabase(productId, name, price, status, restaurantName, discountRate);
        
        list.add(menu);
       
        list.display();
         }while(choice== 'Y'||choice =='y');

        System.out.println(list.size());

         mainMenu();
    }
    
    public void displayMenu(){
        
        String s ="Status";
        String id = "Product ID";
        String name="Product Name";
        String p = "Product Price";
        String d = "Discount Rate";
        String rtName= "Restaurant Name";
        int sort=0;
//         Menu m1 = new Menu("ABC123","coconut",12.00,restaurantName,true,0);
//         Menu m2 = new Menu("ABC124","papaya",11.00,restaurantName,true,0.2);
//         Menu m3 = new Menu("ABC125","durian",100.00,restaurantName,false,0.15);
//         Menu m4 = new Menu("ABC126","coco",15.00,restaurantName,true,2);
//         list.add(m1);
//         list.add(m2);
//         list.add(m3);
//         list.add(m4);
        
        System.out.format("NO |%-16s | %-15s | %-23s |%-16s |%-16s|"+s , id, name,p,rtName,d);
        System.out.println("");
        System.out.println("____________________________________________________________________________________________________________");
//        for(int i=0;i<list.size();i++){
//        System.out.println("" + i +". " + list.get(i));
//        
//        
//     }
        for(int i=list.size()-1;i>=0;i--){
            System.out.println("" + sort +". " + list.get(i));
            sort++;
        }
        
        System.out.println("");
        System.out.println("");
        mainMenu();
    }
    public void removeItem(){
        int deleteChoice;
        
        System.out.println("Menu Contents: ");
        for(int i=0;i<list.size();i++){
        System.out.println("" + i +". " + list.get(i));
         }
        
        System.out.println("Enter No to delete");
        deleteChoice=Integer.parseInt(scanner.nextLine());
        list.remove(deleteChoice);
        System.out.println("Delete Successful");
        mainMenu();
      
    }
    public void updateMenu(){
         int updateChoice;
         String productId="";
         String name="";
         double price;
         boolean status = true;
         char available='Y';
         double discountRate =0.0;
         String dbTemp="";
         
        System.out.println("Menu Contents: ");
        for(int i=0;i<list.size();i++){
        System.out.println("" + i +". " + list.get(i));
        dbTemp=list.get(i).getProdId();
         }
        System.out.println("Enter No to update");
        updateChoice=Integer.parseInt(scanner.nextLine());
        
        System.out.println();
        System.out.println("Enter Product ID: ");       
        productId = scanner.nextLine();
        System.out.println(""); 
        System.out.println("Enter Product Name: ");       
        name = scanner.nextLine();
        System.out.println("");
        System.out.println("Enter Product Price : ");
        price = Double.parseDouble(scanner.nextLine());
             
        System.out.println("Enter Discount Rate : ");
        discountRate = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Available Now ? (Y/N)");
        available=scanner.next().charAt(0);
        if(available=='Y' || available =='y'){
            status=true;
        }else{
            status=false;
        }
        
        //Update database
        MenuData data = new MenuData();
        data.updateLocalDatabase(productId, name, price, status, restaurantName, discountRate, dbTemp);
        
        Menu menu = new Menu(productId,name,price,restaurantName,status,discountRate);
        list.replace(menu,updateChoice);
        scanner.nextLine();
        System.out.println("Update Successful");
        
        
        
        mainMenu();
        
     } 
    public void displayPromotionItem(){
        String s ="Status";
        String id = "Product ID";
        String name="Product Name";
        String p = "Product Price";
        String d = "Discount Rate";
        String rtName= "Restaurant Name";   
         int sort=0;
        System.out.format("NO |%-16s | %-15s | %-23s |%-16s |%-16s|"+s , id, name,p,rtName,d);
        System.out.println("");
        System.out.println("____________________________________________________________________________________________________________");
         for(int a=0 ;a<list.size();a++){
             if(list.get(a).getDiscountRate()>0){
                 System.out.println("" + sort +". " + list.get(a));
                 sort++;
             }
             
         }
         
         for(int a=0 ;a<list.size();a++){
             if(list.get(a).getDiscountRate()==0){
                 System.out.println("" + sort +". " + list.get(a));
                 sort++;
             }
             
         }
         mainMenu();
     }
    public void displayAvailableItem(){
        String s ="Status";
        String id = "Product ID";
        String name="Product Name";
        String p = "Product Price";
        String d = "Discount Rate";
        String rtName= "Restaurant Name";   
         
        System.out.format("NO |%-16s | %-15s | %-23s |%-16s |%-16s|"+s , id, name,p,rtName,d);
        System.out.println("");
        System.out.println("____________________________________________________________________________________________________________");
                  for(int a=0 ;a<list.size();a++){
             if(list.get(a).getStatus()==true){
                 System.out.println("" + a +". " + list.get(a));
             }
             
             
         }
                  mainMenu();
                          
     }
    public void searchItem(){
         String search;
        String s ="Status";
        String id = "Product ID";
        String name="Product Name";
        String p = "Product Price";
        String d = "Discount Rate";
        String rtName= "Restaurant Name";   
        int sort = 0;
         System.out.println("Enter product name to search Item :");
         search=scanner.nextLine();
         
         System.out.format("NO |%-16s | %-15s | %-23s |%-16s |%-16s|"+s , id, name,p,rtName,d);
        System.out.println("");
        System.out.println("____________________________________________________________________________________________________________");
         for(int a=0 ;a<list.size();a++){
             if(list.get(a).getName().contains(search)){
                 System.out.println("" + sort +". " + list.get(a));
                 sort++;
             }
     }
         mainMenu();
     }
    public void register(){
            System.out.println("Enter Your Restaurant Name");
            restaurantName=scanner.nextLine();
            System.out.println("Register Successful");
            mainMenu();
        }
    public void mainMenu(){
          
          System.out.println("---------------------------------------------------\n M A I N            M E N U \n");
          int choice;
         System.out.println("1.Add Item to Menu");
         System.out.println("2.Display Newest Item First");
         System.out.println("3.Display Promotional Item First");
         System.out.println("4.Remove Item From Menu");
         System.out.println("5.Update Item From Menu");
         System.out.println("6.Display Available Item");
         System.out.println("7.Search Item");
         System.out.println("8.Register as affiliate");
         choice = scanner.nextInt();
         scanner.nextLine();
         if(choice == 1){
             addItem();
         }
         if(choice == 2)
         {
             displayMenu();
         }
          if(choice == 3)
         {
             displayPromotionItem();
         }
          if(choice==4)
          {
              removeItem();
          }
          if(choice==5)
          {
              updateMenu();
          }
          if(choice==6)
          {
              displayAvailableItem();
          }

          if(choice==7)
          {
              searchItem();
          }
          if(choice==8)
          {
              register();
          }
         
      }
     
 
    
}
