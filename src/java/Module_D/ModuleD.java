package Module_D;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author AshLim
 */
public class ModuleD {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        mainmenu();
    }
        
    public static void mainmenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the menu: ");
        System.out.println("1.Check Details");
        System.out.println("2.Check in and Check Out");
        System.out.println("3.Check Remaining time");
        System.out.printf("Your choice is :");
        int choice = scanner.nextInt();
        if (choice == 1) {
            checkdetails();
        } else if (choice == 2) {
            checkinout();
        } else if (choice == 3) {
            remainingtime();
        }
    }

    public static void remainingtime() {
        String state;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your orderID: ");
        String orderID = scanner.nextLine();
        postcode();
        System.out.println("================================================================================");
        System.out.println("Please kindly wait our deliveryman to deliver your delicious food.Welcome Back~");
    }

    public static void postcode() {
        String state;
        String deliveryman = "Ali bin abu bakar";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your address: ");
        String address = scanner.nextLine();
        System.out.printf("Enter the postcode: ");
        int postcode = scanner.nextInt();
        if (postcode == 42100) {
            state = "Selangor";
            System.out.println("================================================================================");
            System.out.println("Address: " + address);
            System.out.println("State: " + state);
            System.out.println("Estimate time: 10 min");
            System.out.println("Deliveryman: " + deliveryman);
        } else if (postcode == 82100) {
            state = "Johor";
            System.out.println("================================================================================");
            System.out.println("Address: " + address);
            System.out.println("State: " + state);
            System.out.println("Estimate time: 20 min");
            System.out.println("Deliveryman: " + deliveryman);
        } else {
            System.out.println("Invalid postcode Please enter again.");
            postcode();
        }
    }

    public static void checkdetails() {
        // TODO code application logic here
        String man[][] = {{"1001", "Lim Zhi Hui", "Y", "\t", "1.00-2.00"},
        {"1002", "Aw Khaw Wai", "N", "Deliver burger", "11.00-12.00"},
        {"1003", "Yong Kai Xiong", "N", "Deliver noodles", "2.30-3.30"},
        {"1004", "Chua Wei Han", "Y", "\t", "2.00 - 3.00"}};

        System.out.println("Staff ID\tStaff Name\t\tAvailable\tDelivery Description\tBreak-time");

        for (int row = 0; row < man.length; row++) {
            for (int col = 0; col < man[row].length; col++) {
                System.out.print(man[row][col] + "\t\t");
            }
            System.out.println();
        }

    }

    private static class Delivery {

        private int staffID;
        private String staff_name;
        private char available;
        private String delivery;
        private String break_time;

        public Delivery(int staffID, String staff_name, char available, String delivery, String break_time) {
            this.staffID = staffID;
            this.staff_name = staff_name;
            this.available = available;
            this.delivery = delivery;
            this.break_time = break_time;
        }

        public int getStaffID() {
            return staffID;
        }

        public String getStaff_name() {
            return staff_name;
        }

        public char getAvailable() {
            return available;
        }

        public String getDelivery() {
            return delivery;
        }

        public String getBreak_time() {
            return break_time;
        }

        public void setStaffID(int staffID) {
            this.staffID = staffID;
        }

        public void setStaff_name(String staff_name) {
            this.staff_name = staff_name;
        }

        public void setAvailable(char available) {
            this.available = available;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }

        public void setBreak_time(String break_time) {
            this.break_time = break_time;
        }

        @Override
        public String toString() {
            return "Delivery:\n" + "==========================" + "\nStaff ID =" + staffID + "\nStaff Name =" + staff_name + "\nAvailable =" + available + "\nDelivery =" + delivery + "\nBreak_time =" + break_time;
        }

    }

    public static void checkinout() {
        int staffid;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your staff ID:");
        staffid = scanner.nextInt();
        if (staffid >= 0) {
            System.out.println("Proceed to page...");
            Date date = new Date();
            int condition;
            int yes = 1;
            int no = 2;
            System.out.println("Clock In and Clock in");
            System.out.println("======================");
            System.out.println("1.Clock in");
            System.out.println("2.Clock Out");
            int decision = scanner.nextInt();
            if (decision == 1) {
                System.out.println("Staff id :" + staffid);
                System.out.println("Clock in Time:" + date.toString());
                System.out.println("Clock In Sucessful!!");
                System.out.println("Continue?(y/n)");
                System.out.println("1.Yes");
                System.out.println("2.No");
                condition = scanner.nextInt();
                if (no == condition) {
                    System.out.println("Thank You");
                } else if (yes == condition) {
                    checkinout();
                }
            } else if (decision == 2) {
                System.out.println("Staff id :" + staffid);
                System.out.println("Clock Out Time:" + date.toString());
                System.out.println("Clock Out Sucessful!!");
                System.out.println("Continue?(y/n)");
                System.out.println("1.Yes");
                System.out.println("2.No");
                condition = scanner.nextInt();
                if (no == condition) {
                    System.out.println("Thank You");
                } else if (yes == condition) {
                    checkinout();
                }
            } else {
                System.out.println("Invalid Menu Number.");
                checkinout();
            }
        } else {
            System.out.println("Invalid Staff Id");
            checkinout();

        }
    }

}

