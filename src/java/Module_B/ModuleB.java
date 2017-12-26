/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_B;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import static javafx.application.Platform.exit;



/**
 *
 * @author C K
 */
public class ModuleB {

    public static String select;
    public static int choice;
    public static Scanner scanner = new Scanner(System.in);
    public static listInterface<Staff> staffList = new List<>(); 
    public static listInterface<Pending> pendingList = new List<>();
    
    public ModuleB(){
        Menu();
    }
    
    public static void Menu(){
    
        Scanner reader = new Scanner(System.in);
        int selection;
        System.out.println("\nHR Executive ");
        System.out.println("==============");
        System.out.println("1.Add New Staff");
        System.out.println("2.Update Staff Details");
        System.out.println("3.Retrieve Pending Delivery");
        System.out.println("4.Retrieve Daily Report");
        System.out.println("5.Retrieve Staff List");
        System.out.println("0.Exit");
        System.out.println("\nPlease enter number:");
        selection = reader.nextInt();
        
        
        if(selection==1)
        {
            
            AddStaff();
            
        }
        
        else if(selection==2)
        {
        
            UpdateStaff();
            
        }
        
        else if(selection==3)
        {
        RetrievePending();
            
        }
        else if(selection==4)
        {
        
            DailyReport();
        }
        
        else if(selection==5)
        {
        
            StaffList();
        }
        
        else
        {
         System.out.println("Thank you for using this system ! have a Good Day !");
        }
         
    }
    
    public static void AddStaff(){
    
        
        do{
        Staff staff= new Staff();
            System.out.println("\nPlease enter following information : ");
            System.out.print("\nName         :");
            staff.setAstaff_name(scanner.nextLine());
                
        
            System.out.print("\nIC Number    :");
            staff.setAstaff_icNo(scanner.nextLine());
        
            System.out.print("\nPhone Number :");
            staff.setAstaff_phoneNo(scanner.nextLine());
        
            System.out.print("\nStatus       :");
            staff.setAstaff_status(scanner.nextLine());
        
            System.out.print("\nGender       :");
            staff.setAstaff_gender(scanner.nextLine());
        
            System.out.print("\nUsername     :");
            staff.setAstaff_userName(scanner.nextLine());
        
       
            staffList.add(staff);
            System.out.println("\nStaff added sucessfully!!!");
        
            System.out.println("\n**Continue to add staff? (Y for YES | N for NO | E for EXIT )");
            select=scanner.nextLine().toUpperCase();
            
        }while(select.equals("Y"));
        
        if(select.equals("N"))
        {
        
            Menu();
            
        }
        else if(select.equals("E"))
        {
        
            exit();
        }
    }
    
    public static void UpdateStaff(){
    
        Staff staff= new Staff();
        
        if(staffList.isEmpty())
        {
        
            System.out.println("\n**No staff record!**");
            Menu();
        }
        else
        {
        
            System.out.println("**Staff List**");
            System.out.println("=================");
            for(int k=1;k<=staffList.size();k++)
        {
        
            System.out.println(k+"."+staffList.getEntry(k));
        }
            System.out.println("\nPlease enter the number of staff : ");
            choice = Integer.parseInt(scanner.nextLine());
            
        System.out.print("Name          :");
        staff.setAstaff_name(scanner.nextLine());
                
        
        System.out.print("IC Number     :");
        staff.setAstaff_icNo(scanner.nextLine());
        
        System.out.print("Phone Number  :");
        staff.setAstaff_phoneNo(scanner.nextLine());
        
        System.out.print("Status        :");
        staff.setAstaff_status(scanner.nextLine());
        
        System.out.print("Gender        :");
        staff.setAstaff_gender(scanner.nextLine());
        
        System.out.print("Username     :");
        staff.setAstaff_userName(scanner.nextLine());
        
        
        staffList.update(choice, staff);
         for(int y=1;y<=staffList.size();y++)
        {
        
            System.out.println(y+"."+staffList.getEntry(y));
        }
         
            System.out.println("Continue to update? (Y for YES | N for NO | E for EXIT )");
            select=scanner.nextLine().toUpperCase();
            
            if(select.equals("Y"))
            {
            
                UpdateStaff();
            }
            else if(select.equals("N"))
            {
            
                Menu();
            }
            
            else if(select.equals("E"))
            {
            
                exit();
            }
         
        }
        
        
    }
    
    public static void RetrievePending(){
    
        Pending pending = new Pending();
        String staffName="";
        String staffID="";
        String orderID="";
        
        pending.setStaff_Name("ASH");
        pending.setStaff_ID("A1001");
        pending.setOrder_ID("123");
        pendingList.add(pending);
        
        
        System.out.println(pendingList);
        
        
    }
    
    public static void DailyReport()
    {
    
        class Report
     {
        int total_d;
        String name, distance;
 
    // Constructor
    //int total_d, String name, String distance  String name, int total_d, String distance
    public Report(String name, int total_d, String distance)
    {
        this.total_d = total_d;
        this.distance = distance;
        this.name = name;
    }
 
    // Used to print student details in main()
    public String toString()
    {
        return this.name + "\t\t" + this.total_d +
                           "\t\t" + this.distance;
    }
}
 
    class SortbyTotal_Delivery implements Comparator<Report>
    {
          public int compare(Report a, Report b)
        {
          return b.total_d - a.total_d;
       }
}
       
         Report [] arr = {new Report("Staff 111", 33, "150"),
                          new Report("Shin Tan",80 , "300"),
                          new Report("Tosh 234",65 , "200")
         };
 
              
              
              
              
              Arrays.sort(arr, new SortbyTotal_Delivery());
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
              LocalDate localDate = LocalDate.now();
              
              System.out.println("\n**Daily Report**       \t\tDate : "+dtf.format(localDate));
              System.out.println("======================================================");
              System.out.println("=Delivery Man =  Total Delivery =  Total Distance(km)=");
              System.out.println("======================================================");
              for (int i=0; i<arr.length; i++)
              System.out.println(arr[i]);
              System.out.println("---------------------------------------------");
              System.out.println("\n(Enter M for MENU | E for EXIT )");
              select=scanner.nextLine().toUpperCase();
            
            if(select.equals("M"))
            {
            
                Menu();
            }
            
            
            else if(select.equals("E"))
            {
            
                exit();
            }
         
        
    }
    
    public static void StaffList(){
    
        
        
        if(staffList.isEmpty())
        {
        
            System.out.println("\nNo Record found!!");
            Menu();
        }
        
        else{
        
        System.out.println("All Staff");
        System.out.println("===========");
                 for(int y=1;y<=staffList.size();y++)
        {
        
            System.out.println("\n"+y+"."+staffList.getEntry(y));
        }
        }
                      System.out.println("\n(M for MENU | E for EXIT )");
              select=scanner.nextLine().toUpperCase();
            
            if(select.equals("M"))
            {
            
                Menu();
            }
            
            
            else if(select.equals("E"))
            {
            
                exit();
            }

        
    }
}