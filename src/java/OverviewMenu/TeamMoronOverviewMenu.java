package OverviewMenu;

import Module_A.*;
import Module_B.*;
import Module_C.*;
import Module_D.*;

import java.util.Scanner;

public class TeamMoronOverviewMenu {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ModuleA addmenu = new ModuleA();
        AddStaff addstaff = new AddStaff();
        ModuleD moduleD = new ModuleD();
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
                addmenu.mainMenu();
            }
            else if (response == 2){
                addstaff.Menu();
            }
            else if (response == 3){
                System.out.println("For customer/client side, please access servlet files manually");
                CustomerInfoRetrieval retrieve = new CustomerInfoRetrieval();
            }
            else if (response == 4){
                moduleD.mainmenu();
            }
            
            System.out.println("More operations? (Enter 1 for yes)");
            more = scanner.nextInt();
        }while (more == 1);
        
    }
}
