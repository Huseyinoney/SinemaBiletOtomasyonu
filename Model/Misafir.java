package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.DBConnection;

public class Misafir {

	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	private int misafirId;

	public Misafir(int misafirId) {
		super();
		this.misafirId = misafirId;
	}

	public int getMisafirId() {
		return misafirId;
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
	
	
}
