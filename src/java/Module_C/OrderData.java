/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author lenovo
 */
public class OrderData {
    
    private String orderID;
    private String itemID;
    private String itemName;
    private double unitPrice;
    private int quantity;
    private double totalUnitPrice;
    private String restaurantName;
    double discount;
    
    public OrderData(){
        this.orderID = null;
        this.itemID = null;
        this.itemName = null;
        this.unitPrice = 0;
        this.quantity = 0;
        this.totalUnitPrice = 0;
        this.restaurantName = null;
        this.discount = 0;
    }
    
    public OrderData(String orderID, String itemID, String itemName, double unitPrice, int quantity, String restaurantName, double discount){
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalUnitPrice = calculateUnitTotal(unitPrice, quantity, discount);
        this.restaurantName = restaurantName;
        this.discount = discount;
    }
    
    public OrderData(String itemID, String itemName, double unitPrice, int quantity, String restaurantName, double discount){
        this.orderID = generateOrderID();
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalUnitPrice = calculateUnitTotal(unitPrice, quantity, discount);
        this.restaurantName = restaurantName;
        this.discount = discount;
    }
    
    //Data methods
    public void setOrderID(String orderID){
        this.orderID = generateOrderID();
    }
    public void setItemID(String itemID){
        this.itemID = itemID;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setTotalPrice(){
        this.totalUnitPrice = unitPrice * quantity;
    }
    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }
    public void setDiscount(double Discount){
        this.discount = discount;
    }
    public void setName(String itemName){
        this.itemName = itemName;
    }
    
    public String getOrderID(){
        return this.orderID;
    }
    public String getItemID(){
        return this.itemID;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public double getTotalUnitPrice(){
        return this.totalUnitPrice;
    }
    public String getRestaurantName(){
        return this.restaurantName;
    }
    public double getDiscount(){
        return this.discount;
    }
    public String getItemName(){
        return this.itemName;
    }
    
    //Supportive methods
    public double calculateUnitTotal(double price, int quantity, double discount){
        return ((price * quantity) * (1.00-discount));
    }
    public String generateOrderID(){
        String orderID = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement pstmtRestaurant = conn.prepareStatement("Select orderid from ordering group by orderid");
            ResultSet resultCount = pstmtRestaurant.executeQuery();
            int count = 1;
            for (;resultCount.next();count++){
                
            }
            orderID = orderIDSerialGenerator(count, 1, 6);
        }
        catch (SQLException ex){
            System.out.println("SQL Exception has occured");
        }
        return orderID;
    }
    public String orderIDSerialGenerator(int orderIndex, int initial, int zero){
        initial = initial*10;
        if(orderIndex < initial){
            
        }
        else {
            orderIDSerialGenerator(orderIndex, initial, zero-1);
        }
        return "ORD"+zeroString(zero)+orderIndex;
    }
    public String zeroString(int number){
        String zero = "";
        for (int counter = 0; counter < number; counter++){
            zero = zero + "0";
        }
        return zero;
    }
    
    //Database Ordering Table insert
    public void insertNewOrder(OrderStack stack){
        try {
            OrderData[] order = new OrderData[stack.length+1];
            int stackLength = stack.length+1;
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            
            for (int count = 0; count < stackLength; count++){
                order[count] = (OrderData)stack.pop();
                PreparedStatement pstmtInsert = conn.prepareStatement("insert into ordering values ( ?, ?, ?, ?, ?, ?)");
                pstmtInsert.setString(1, order[count].getOrderID());
                pstmtInsert.setString(2, order[count].getItemID());
                pstmtInsert.setDouble(3, order[count].getUnitPrice());
                pstmtInsert.setInt(4, order[count].getQuantity());
                pstmtInsert.setDouble(5, order[count].getTotalUnitPrice());
                pstmtInsert.setString(6, order[count].getRestaurantName());
                
                pstmtInsert.execute();
            }             
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        
    }
    
    public ResultSet getOrderData(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            
            PreparedStatement pstmtGet = conn.prepareStatement("SELECT * FROM CUSTOMER_DELIVERY where delivered = false");
            ResultSet rsData = pstmtGet.executeQuery();
            
            return rsData;
        }
        catch (SQLException ex){
            System.err.println(ex);
            return null;
        }
    }
}
