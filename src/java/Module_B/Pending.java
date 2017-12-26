/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_B;

/**
 *
 * @author C K
 */
class Pending {
    private String staff_Name;
    private String staff_ID;
    private String order_ID;
  
    
    public Pending(){
    
        this("","","");
    }
    
    public Pending(String Astaff_name,String Astaff_icNo,String Astaff_phoneNo){
    
        this.staff_Name=staff_Name;
        this.staff_ID=staff_ID;
        this.order_ID=order_ID;
        

        
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        this.staff_Name = staff_Name;
    }

    public String getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(String staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }
    public String toString(){
    
        return "Staff Name  | "+"Staff ID  | "+"Order ID | "+"\n"+"===================================="+"\n"+staff_Name+"     \t"+staff_ID+"     \t"+order_ID;
    }
    
    
}
