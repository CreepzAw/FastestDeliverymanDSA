package Module_C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class MenuData {
    
    private String ID;
    private String name;
    private double price;
    private boolean availabilityStatus;
    
    private String restaurantName;
    private double discountRate;
    
    //Empty constructor that sets values to default of empty
    public MenuData(){
        this.ID = "";
        this.name = "";
        this.price = 0.00;
        this.availabilityStatus = false;
        this.restaurantName = "";
        this.discountRate = 0.00;
    }
    
    public MenuData(String ID, String name, double price, boolean status, String restaurantName, double discountRate){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.availabilityStatus = status;
        this.restaurantName = restaurantName;
        this.discountRate = discountRate;
    }
    
    //Information set methods
    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStatus(boolean status){
        this.availabilityStatus = status;
    }
    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }
    public void setDiscount(double discountRate){
        this.discountRate = discountRate;
    }
    
    //Information getMethods
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public boolean getStatus(){
        return this.availabilityStatus;
    }
    public String getResturantName(){
        return this.restaurantName;
    }
    public double getDiscount(){
        return this.discountRate;
    }
    
    //Menu Database
    public void addLocalDatabase(String ID, String name, double price, boolean status, String restaurantName, double discountRate){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement insert = conn.prepareStatement("Insert into Menu values (?, ?, ?, ?, ?, ?)");
            insert.setString(1, ID);
            insert.setString(2, name);
            insert.setDouble(3, price);
            insert.setBoolean(4, status);
            insert.setString(5, restaurantName);
            insert.setDouble(6, discountRate);
            insert.execute();
        }
        catch (Exception ex){
            System.out.println("Database connection failed");
        }
    }
    public void deleteLocalDatabase(String ID){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement delete = conn.prepareStatement("delete from Menu where ID=?");
            delete.setString(1, ID);
            delete.execute();
        }
        catch (Exception ex){
            System.out.println("Database connection failed");
        }
    }
    public void updateLocalDatabase(String ID, String name, double price, boolean status, String restaurantName, double discountRate, String selectedID){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement insert = conn.prepareStatement("update Menu set ID=?, Name=?, Price=?, Status=?, RestaurantName=?, Discount=? where id=?");
            insert.setString(1, ID);
            insert.setString(2, name);
            insert.setDouble(3, price);
            insert.setBoolean(4, status);
            insert.setString(5, restaurantName);
            insert.setDouble(6, discountRate);
            insert.setString(7, selectedID);
            
            insert.execute();
        }
        catch (Exception ex){
            System.out.println("Database connection failed");
        }
    }
    
    public String toString(){
        return "ID: "+ID+" "+"Name: "+name+" "+"Price: "+price+" "+"Status: "+availabilityStatus+" "+"Restaurant Name: "+restaurantName+" "+"Discount Rate: "+discountRate+" ";
    }
}
