package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.DBConnection;

public class User {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	private int userID;
	private String userName;
	private String password;
	
	public User(int userID, String userName, String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
	}

	public int getuserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<Film> getFilmList() throws SQLException{
		ArrayList<Film> list = new ArrayList<>();
		Film obj;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM film");
			while (rs.next()) {
				obj = new Film(rs.getInt("FilmId"),rs.getString("filmName"),rs.getString("type"),rs.getString("image"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
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

