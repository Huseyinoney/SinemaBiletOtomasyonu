package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//import com.mysql.cj.jdbc.Blob;

import Controller.DBConnection;

public class Film {
	
	private int filmId;
	private String filmName;
	private String type;
	private Blob image;
	
	DBConnection conn = new DBConnection();
	Connection con = DBConnection.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Film () {}
	
	public Film(int filmId, String filmName, String type, Blob image) {
		super();
		this.filmId = filmId;
		this.filmName = filmName;
		this.type = type;
		this.image = image;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
	public ArrayList<Film> getFilmList() throws SQLException{
		ArrayList<Film> list = new ArrayList<>();
		Film obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM film");
			while (rs.next()) {
				obj = new Film(rs.getInt("FilmId"), rs.getString("FilmAdi"),rs.getString("FilmTur"),rs.getBlob("Gorsel"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	
}
