package Module_C;

import java.util.Scanner;
import java.sql.*;

public class CustomerDeliveryInfo {
    private String name;
    private String orderID;
    private String address;
    private String contactNumber;
    private boolean delivered;
    
    public CustomerDeliveryInfo(){
        name = "";
        orderID = "";
        address = "";
        contactNumber = "";
        delivered = false;
    }
    public CustomerDeliveryInfo(String name, String orderID, String address, String contactNumber, boolean deliveryStatus){
        this.name = name;
        this.orderID = orderID;
        this.address = address;
        this.contactNumber = contactNumber;
        this.delivered = deliveryStatus;
    }
    
    //information method
    public String getName() {
        return name;
    }
    public String getOrderID() {
        return orderID;
    }
    public String getAddress() {
        return address;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public boolean isDelivered() {
        return delivered;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public void setAddress(String address) {
            this.address = address;
        }
    public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    
    public void addIntoLocalDatabase(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleC", "ModuleC", "ModuleC");
            PreparedStatement insert = conn.prepareStatement("Insert into customer_delivery values (?,?,?,?,?)");
            insert.setString(1, name);
            insert.setString(2, address);
            insert.setString(3, contactNumber);
            insert.setBoolean(4, delivered);
            insert.setString(5, orderID);
            
            insert.execute();
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }
}
