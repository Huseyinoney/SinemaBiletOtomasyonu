package Model;

import java.sql.*;
import java.util.ArrayList;

import Controller.DBConnection;

public class Admin {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int id;
	private String adminname;
	private String password;
	
	public Admin() {}
	
	public Admin(int id, String adminname, String password) {
		
		this.id = id;
		this.adminname = adminname;
		this.password = password;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean updateAdmin(int ID, String kAdi, String Sifre) throws SQLException{
		String query = "UPDATE admin SET kAdi=?, Sifre=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kAdi);
			preparedStatement.setString(2, Sifre);
			preparedStatement.setInt(3, ID);
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
	
	
	
	
	//SÄ°NEMA Ä°Å�LEMLERÄ°
	public ArrayList<Film> getSinemaList() throws SQLException{
		ArrayList<Film> list = new ArrayList<>();
		Film obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM film");
			while (rs.next()) {
				obj = new Film(rs.getInt("FilmId"),rs.getString("FilmAdi"),rs.getString("FilmTur "),rs.getBlob("Gorsel"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public boolean addFilm(String FilmAdi,String FilmTur) throws SQLException{
		String query = "INSERT INTO film (FilmAdi, FilmTur) VALUES ('" + FilmAdi +  "','" + FilmTur +  "')";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, FilmAdi);
			preparedStatement.setString(2, FilmTur);
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
	
	
	public boolean deleteFilm(String FilmAdi) throws SQLException{
		String query = "DELETE FROM film WHERE FilmAdi = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, FilmAdi);
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
	
	public boolean updateFilm(String FilmAdi, String FilmTur) throws SQLException{
		String query = "UPDATE film SET FilmTur='" + FilmTur + "' WHERE FilmAdi = '" + FilmAdi + "' ";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, FilmAdi);
			preparedStatement.setString(2, FilmTur);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	public ArrayList<User> getUserList() throws SQLException{
		ArrayList<User> userlist = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				obj = new User(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("username"), rs.getString("password"), rs.getString("mail"));
				userlist.add(obj);
			} 	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return userlist;
	}
	
	public boolean addUser(String UserName, String Password) throws SQLException{
		int key = 0;
		boolean duplicate = false;
		String query = "INSERT INTO user" + "(kAdi, Sifre) VALUES" + "(?,?)";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE kAdi = '" + UserName +  "'");
			while (rs.next()) {
				duplicate = true;
				break;
			}
			
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, UserName);
				preparedStatement.setString(2, Password);
				
				
				preparedStatement.executeUpdate();
				key = 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key==1) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	public boolean deleteUser(String username) throws SQLException{
		String query = "DELETE FROM user WHERE username = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
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
	
	
	
	public boolean updateUser(int ID,String UserName, String Password) throws SQLException{
		String query = "UPDATE user SET UserName=?, Password=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, UserName);
			preparedStatement.setString(2, Password);
			preparedStatement.setInt(3, ID);
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
