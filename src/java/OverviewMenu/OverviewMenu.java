package OverviewMenu;

import Module_A.*;
import Module_B.*;
import Module_C.*;
import Module_D.*;

import java.util.Scanner;

public class OverviewMenu {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int more = 0;
        
        do {
            more = 0;
            System.out.println("Select an item below to start: ");
            System.out.println("1. Module A");
            System.out.println("2. Module B");
            System.out.println("3. Module C");
            System.out.println("4. Module D");

            int response = scanner.nextInt();
            if (response == 1){
                ModuleA moduleA = new ModuleA();
            }
            else if (response == 2){
                ModuleB moduleB =  new ModuleB();
            }
            else if (response == 3){
                System.out.println("For customer/client side, please access servlet file name RestaurantMenu manually");
                CustomerInfoRetrieval retrieve = new CustomerInfoRetrieval();
            }
            else if (response == 4){
                ModuleD moduleD = new ModuleD();
            }
            
            System.out.println("More operations? (Enter 1 for yes)");
            more = scanner.nextInt();
        }while (more == 1);
        
    }
}
