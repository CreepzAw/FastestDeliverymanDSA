/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_C;

import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class ModuleC_MainMenu {
    Scanner scanner = new Scanner(System.in);
    Menu_Ordering ordering = new Menu_Ordering();
    
    public ModuleC_MainMenu(){
        int redo = 0;
        do {
            System.out.println("Select an option below: ");
            System.out.println("1. Customer (Ordering section)");
            System.out.println("2. Staff (View customer information)");
            int option = scanner.nextInt();
            String newLineEater = scanner.nextLine();
            if (option == 1){
                ordering.classMenu();
            }
            else if (option == 2){
                CustomerInfoRetrieval info = new CustomerInfoRetrieval();
            }
            
            System.out.println("More process in this module? (Enter 1 to continue)");
            redo = scanner.nextInt();
        }while (redo == 1);
        
    }
}
