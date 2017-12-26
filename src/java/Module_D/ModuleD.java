/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_D;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author lim zhi hui
 */
public class ModuleD {
    public String order;
    private QueueInterface<Delivery> deliverylist = new LinkedQueue<>();
    Delivery deliveryman1 = new Delivery(1001, "Lim ZH", "12:00:00", "available");
    Delivery deliveryman2 = new Delivery(1002, "Chua WH", "12:00:00", "delivery");
    Delivery deliveryman3 = new Delivery(1003, "David CL", "12:00:00", "break");

    public void mainmenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the menu: ");
        System.out.println("1.Check Details");
        System.out.println("2.Check in and Check Out");
        System.out.println("3.Allocate Task");
        System.out.println("4.Track Order");
        System.out.printf("Your choice is :");
        int choice = scanner.nextInt();
        if (choice == 1) {
            CheckDetails();
        } else if (choice == 2) {
            checkinout();
        } else if (choice == 3) {
            AllocateTask();
        } else if (choice == 4) {
            RemainingTime();
        }
    }

    public void AllocateTask() {
        Scanner scanner = new Scanner(System.in);
        deliverylist.addDeliveryMan(deliveryman1);
        deliverylist.addDeliveryMan(deliveryman2);
        deliverylist.addDeliveryMan(deliveryman3);
        String available = "available";
        String delivery = "delivery";
        String breaktime = "break";
        System.out.println("Enter the staff ID: ");
        int staffid = scanner.nextInt();
        for (int a = 0; a > deliverylist.getLength(); a++) {
            if (deliverylist.getEntry(a).getAvailable() == available) {
                deliverylist.getEntry(a).setAvailable("delivery");
            } else if (deliverylist.getEntry(a).getAvailable() == delivery) {
                System.out.println("Current deliveryman is in delivery task.");

            } else if (deliverylist.getEntry(a).getAvailable() == breaktime) {
                System.out.println("Current deliveryman is on break.");
            }
            
        }

        if (staffid == 1001) {
            System.out.println("Enter the task needed to allocate:");
            String task = scanner.next();
            deliveryman1.setAvailable("delivery");
            Delivery delivery2 = new Delivery(deliveryman1.getStaffID(), deliveryman1.getStaff_name(), deliveryman1.getBreak_time(), deliveryman1.getAvailable());
            System.out.println("==================================================");
            System.out.println("Staff id :" + delivery2.getStaffID());
            System.out.println("Staff Name :" + delivery2.getStaff_name());
            System.out.println("Staff Status :" + delivery2.getAvailable());
            System.out.println("Task Allocated :"+task);
            System.out.println("");
        } else if (staffid == 1002) {
            System.out.println("Cuurent Deliveryman is cuurently on task. Please select another deliveryman.");
            AllocateTask();
        } else if (staffid == 1003) {
            System.out.println("Current deliveryman is in breaktme.Please select another deliveryman.");
            AllocateTask();
        } else {
            System.out.println("Invalid StaffID.Please Enter again");
            AllocateTask();
        }
        while (!deliverylist.isEmpty()) {
            System.out.println(deliverylist.listDeliveryMan());
        }
                
    }

    public void RemainingTime() {
        String state;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your orderID: ");
        order = scanner.nextLine();
        postcode();
        System.out.println("================================================================================");
        System.out.println("Please kindly wait our deliveryman to deliver your delicious food.Thank you~");
    }

    public void postcode() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        deliverylist.addDeliveryMan(deliveryman1);
        deliverylist.addDeliveryMan(deliveryman2);
        deliverylist.addDeliveryMan(deliveryman3);
        String state;
        String address1 = "185,Persiaran Sg.Keramat 7,Taman Klang Utama,42100 Klang,Selangor"+"\n Order Id: "+order+"\n Deliveryman Name: "+ deliveryman1.getStaff_name() + "\n ID:"+deliveryman1.getStaffID();
        String address2 = "A-5-9,PV 10 Platinum Lake Condo No.2,Jalan Danau Sauja,53300 Kuala Lumpur"+"\n Order Id: "+order+"\n Deliveryman Name: "+ deliveryman1.getStaff_name() + "\n ID:"+deliveryman1.getStaffID();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the postcode: ");
        System.out.println("1.Selangor(42100)/n2.Kuala Lumpur(53300)");
        int postcode = scanner.nextInt();
        if (postcode == 42100) {
            state = "Selangor";
            System.out.println("================================================================================");
            System.out.println("Address: " + address1);
            System.out.println("State: " + state);
            String selangor = localTime.plusMinutes(10).format(dtf);
            System.out.println("Estimate time: " + selangor);
            System.out.println("Deliveryman: " + deliveryman1.getStaff_name());
        } else if (postcode == 53300) {
            state = "Kuala Lumpur";
            System.out.println("================================================================================");
            System.out.println("Address: " + address2);
            System.out.println("State: " + state);
            String kuala = localTime.plusMinutes(20).format(dtf);
            System.out.println("Estimate time: " + kuala);
            System.out.println("Deliveryman: " + deliveryman1.getStaff_name());
        } else {
            System.out.println("Invalid postcode Please enter again.");
            postcode();
        }
    }

    public void CheckDetails() {
        deliverylist.addDeliveryMan(deliveryman1);
        deliverylist.addDeliveryMan(deliveryman2);
        deliverylist.addDeliveryMan(deliveryman3);
        System.out.println("====================================================");
        System.out.println("Staff ID  Staff Name\t\tClock In/Out Time     Status");
        while (!deliverylist.isEmpty()) {
            System.out.println(deliverylist.listDeliveryMan());
        }
    }

    public void checkinout() {
        deliverylist.addDeliveryMan(deliveryman1);
        deliverylist.addDeliveryMan(deliveryman2);
        deliverylist.addDeliveryMan(deliveryman3);
        int staffid;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your staff ID:");
        staffid = scanner.nextInt();
        System.out.println("Proceed to page...");
        System.out.println("=============================================================");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String break_time = dateFormat.format(date);
        if (staffid == 1001) {
            deliveryman1.setBreak_time(break_time);
            Delivery delivery = new Delivery(deliveryman1.getStaffID(), deliveryman1.getStaff_name(), deliveryman1.getBreak_time(), deliveryman1.getAvailable());
            deliverylist.addDeliveryMan(delivery);
            int condition;
            int yes = 1;
            int no = 2;
            System.out.println("Clock In and Clock in");
            System.out.println("======================");
            System.out.println("1.Clock in");
            System.out.println("2.Clock Out");
            int decision = scanner.nextInt();
            if (decision == 1) {
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock in Time:" + delivery.getBreak_time());
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
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock Out Time:" + delivery.getBreak_time());
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
        } else if (staffid == 1002) {
            deliveryman2.setBreak_time(break_time);
            Delivery delivery = new Delivery(deliveryman2.getStaffID(), deliveryman2.getStaff_name(), deliveryman2.getBreak_time(), deliveryman2.getAvailable());
            deliverylist.addDeliveryMan(delivery);
            int condition;
            int yes = 1;
            int no = 2;
            System.out.println("Clock In and Clock in");
            System.out.println("======================");
            System.out.println("1.Clock in");
            System.out.println("2.Clock Out");
            int decision = scanner.nextInt();
            if (decision == 1) {
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock in Time:" + delivery.getBreak_time());
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
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock Out Time:" + delivery.getBreak_time());
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
        } else if (staffid == 1003) {
            deliveryman3.setBreak_time(break_time);
            Delivery delivery = new Delivery(deliveryman3.getStaffID(), deliveryman3.getStaff_name(), deliveryman3.getBreak_time(), deliveryman3.getAvailable());
            deliverylist.addDeliveryMan(delivery);
            int condition;
            int yes = 1;
            int no = 2;
            System.out.println("Clock In and Clock in");
            System.out.println("======================");
            System.out.println("1.Clock in");
            System.out.println("2.Clock Out");
            int decision = scanner.nextInt();
            if (decision == 1) {
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock in Time:" + delivery.getBreak_time());
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
                System.out.println("Staff id :" + delivery.getStaffID());
                System.out.println("Staff Name :" + delivery.getStaff_name());
                System.out.println("Clock Out Time:" + delivery.getBreak_time());
                System.out.println("Clock Out Sucessful!!");
                System.out.println("Continue?");
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
