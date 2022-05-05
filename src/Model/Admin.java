package Model;

import java.sql.*;
import java.util.ArrayList;

import Helper.DBConnection;

public class Admin extends User{

	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String kAdi,Sifre;
	
	public Admin() {}

	public Admin(int iD, String kAdi, String sifre) {
		this.ID = iD;
		this.kAdi = kAdi;
		this.Sifre = sifre;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getkAdi() {
		return kAdi;
	}

	public void setkAdi(String kAdi) {
		this.kAdi = kAdi;
	}

	public String getSifre() {
		return Sifre;
	}

	public void setSifre(String sifre) {
		this.Sifre = sifre;
	}
	
	
	//ADMÝN ÝÞLEMLERÝ
	
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
	
	
	//SÝNEMA ÝÞLEMLERÝ
	public ArrayList<Sinema> getSinemaList() throws SQLException{
		ArrayList<Sinema> list = new ArrayList<>();
		Sinema obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM sinema");
			while (rs.next()) {
				obj = new Sinema(rs.getInt("ID"),rs.getString("sinemaAdi"),rs.getString("Tarih"),rs.getString("Saat"),rs.getString("Salon"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public boolean addSinema(String sinemaAdi,String Tarih,String Saat, String Salon) throws SQLException{
		String query = "INSERT INTO sinema" + "(sinemaAdi,Tarih,Saat,Salon) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
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
	
	public boolean deleteSinema(int ID) throws SQLException{
		String query = "DELETE FROM sinema WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, ID);
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
	
	public boolean updateSinema(int ID, String sinemaAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "UPDATE admin SET sinemaAdi=?, Tarih=?, Saat=?, Salon=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, ID);
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
