package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.DBConnection;

public class Bilet {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	private int biletID;
	private String userName;
	private String filmName;
	private String salonNumber;
	private String seatNumber;
	private int seansID;
	
	public Bilet(int biletID, String userName, String filmName, String salonNumber, String seatNumber, int seansID) {
		super();
		this.biletID = biletID;
		this.userName = userName;
		this.filmName = filmName;
		this.salonNumber = salonNumber;
		this.seatNumber = seatNumber;
		this.seansID = seansID;
	}

	public int getBiletID() {
		return biletID;
	}

	public void setBiletID(int biletID) {
		this.biletID = biletID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getSalonNumber() {
		return salonNumber;
	}

	public void setSalonNumber(String salonNumber) {
		this.salonNumber = salonNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getSeansID() {
		return seansID;
	}

	public void setSeansID(int seansID) {
		this.seansID = seansID;
	}
	
	
	

}
