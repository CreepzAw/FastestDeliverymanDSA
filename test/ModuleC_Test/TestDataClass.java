/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC_Test;

/**
 *
 * @author lenovo
 */
public class TestDataClass {
    String testName;
    double testPrice;
    
    public void setName(String name){
        this.testName = name;
    }
    public void setPrice(double price){
        this.testPrice = price;
    }
    
    public String getName(){
        return this.testName;
    }
    public double getPrice(){
        return this.testPrice;
    }
}
