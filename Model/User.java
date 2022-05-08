package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.DBConnection;

public class User {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	private int id;
	private String userName;
	private String password;
	
	public user(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean changeUserpassword(String kAdi, String Sifre) throws SQLException{
		String query = "UPDATE user SET Sifre=? WHERE kAdi=?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Sifre);
			preparedStatement.setString(2, kAdi);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
}

