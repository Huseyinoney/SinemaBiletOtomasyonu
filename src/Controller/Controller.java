package Controller;

//import Controller.DBConnection;
import java.sql.*;

import Model.User;

public class Controller extends User{
	
	DBConnection conn = new DBConnection();
	static Connection con = DBConnection.DBCon();
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement preparedStatement = null;
	
	
	
	public boolean checkUsername(String username)
	{
	    boolean checkUser = false;
	    String query = "SELECT * FROM `user` WHERE `username` =?";
	    
	    try {
	    	preparedStatement = DBConnection.DBCon().prepareStatement(query);
	    	preparedStatement.setString(1, username);
	        
	        rs = preparedStatement.executeQuery();
	        
	        if(rs.next())
	        {
	            checkUser = true;
	        }
	    } catch (SQLException e) {
	        //TODO
	    }
	     return checkUser;
	}
}

