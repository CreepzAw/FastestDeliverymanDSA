/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_C;

import Module_A.Menu;
/**
 *
 * @author lenovo
 */
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
    
    public MenuData(Menu entries){
        this.ID = entries.getProdId();
        this.name = entries.getName();
        this.price = entries.getPrice();
        this.availabilityStatus = entries.getStatus();
        this.restaurantName = entries.getRestaurantName();
        this.discountRate = entries.getDiscountRate();
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
    public double getDiscountRate(){
        return this.discountRate;
    }
    
    public String toString(){
        return "ID: "+ID+" "+"Name: "+name+" "+"Price: "+price+" "+"Status: "+availabilityStatus+" "+"Restaurant Name: "+restaurantName+" "+"Discount Rate: "+discountRate+" ";
    }
}
