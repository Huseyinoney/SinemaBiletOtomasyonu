package Controller;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class DBConnection {

	Connection c = null;
	

	public Connection DBCon() {
        
       try {
    	   this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon", "root", "");
    	   return c;
       } 
       catch (Exception e) {
    	
    	   
       }
        return c;
    }
}
