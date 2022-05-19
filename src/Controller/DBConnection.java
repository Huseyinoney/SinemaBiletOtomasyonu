package Controller;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class DBConnection {
	

	public static Connection DBCon() {
		
		Connection c = null;
        
       try {
    	   //Class.forName("com.mysql.jdbc.Driver");
    	   c = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon", "root", "12345678");
    	   return c;
       } 
       catch (Exception e) {
    	   System.out.println(e.getMessage());
       }
        return c;
    }
}
