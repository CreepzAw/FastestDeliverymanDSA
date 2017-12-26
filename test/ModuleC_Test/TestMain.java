/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC_Test;

import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TestStackClass stack = new TestStackClass();
        String name;
        double price;
        
        System.out.print("Enter sample name: ");
        name = scanner.nextLine();
        System.out.print("Enter sample price: ");
        price = scanner.nextDouble();
        
        TestDataClass data = new TestDataClass();
        data.setName(name);
        data.setPrice(price);
        
        stack.push(data);
        stack.push(data);
        stack.push(data);
        
        TestDataClass popped;
        
        popped = (TestDataClass)stack.pop();
        System.out.println("Name entered: "+popped.getName()+"\nPrice entered: "+popped.getPrice());
        
        popped = (TestDataClass)stack.pop();
        System.out.println("Name entered: "+popped.getName()+"\nPrice entered: "+popped.getPrice());
        
        popped = (TestDataClass)stack.pop();
        System.out.println("Name entered: "+popped.getName()+"\nPrice entered: "+popped.getPrice());
    }
    
}
