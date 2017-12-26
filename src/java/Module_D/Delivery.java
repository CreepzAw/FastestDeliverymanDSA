package Module_D;

public class Delivery {

    private int staffID;
    private String staff_name;
    private String break_time;
    private String available;

    public Delivery(int staffID, String staff_name, String break_time, String available) {
        this.staffID = staffID;
        this.staff_name = staff_name;
        this.break_time = break_time;
        this.available = available;
    }

    public String getAvailable() {
        return available;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public String getBreak_time() {
        return break_time;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setBreak_time(String break_time) {
        this.break_time = break_time;
    }

    @Override
    public String toString() {
        return String.format("%-9d %-21s %-21s %-21s" ,staffID ,staff_name ,break_time,available);
    }

}
