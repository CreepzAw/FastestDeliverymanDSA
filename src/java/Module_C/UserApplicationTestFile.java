package Module_C;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserApplicationTestFile {
    SQLException sqlError;
    
    public static void main(String[] args) {
        UserApplicationTestFile test = new UserApplicationTestFile();
    }
    
    public UserApplicationTestFile(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleCPrototypedatabase", "ModuleC", "ModuleC");
            
            PreparedStatement pstmtStart = conn.prepareStatement("Select Restaurant_Name from menu group by Restaurant_Name");
            ResultSet searchResult; 
            
            searchResult = pstmtStart.executeQuery();
            
            PreparedStatement pstmt1 = conn.prepareStatement("Select * from Menu where restaurant_name =? AND menu_availability=true");
            pstmt1.setString(1, "Restaurant CK");
            ResultSet menuSearchResult;
            
            menuSearchResult = pstmt1.executeQuery();
            
            for(int counter = 1; searchResult.next(); counter++){
                System.out.println(counter +". "+searchResult.getString("RESTAURANT_NAME"));
            }
            System.out.println("Restaurant Name search test passed");
            
            System.out.printf("%-10s | %-50s | %-6s | %-5s\n", "Index", "Item Name", "Price","Availability");
            for(int counter = 1; menuSearchResult.next(); counter++){
                System.out.printf("%-10d | %-50s | %-6.2f | %-5s\n", counter, menuSearchResult.getString("MENU_NAME"), menuSearchResult.getDouble("MENU_PRICE"), menuSearchResult.getString("MENU_AVAILABILITY"));
            }
            System.out.println("Menu Item Search test passed");
        }
        catch (Exception ex){
            if (ex == sqlError){
                System.out.println("SQL Exception has occured");
            }
        }
        
    }
    
}
