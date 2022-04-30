package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class KonserBilet extends User{
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	int ID;
	String konserAdi, Tarih, Saat, Salon, Koltuk;
	
	public KonserBilet() {}

	public KonserBilet(int iD, String konserAdi, String tarih, String saat, String salon, String koltuk) {
		super();
		this.ID = iD;
		this.konserAdi = konserAdi;
		this.Tarih = tarih;
		this.Saat = saat;
		this.Salon = salon;
		this.Koltuk = koltuk;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getKonserAdi() {
		return konserAdi;
	}

	public void setKonserAdi(String konserAdi) {
		this.konserAdi = konserAdi;
	}

	public String getTarih() {
		return Tarih;
	}

	public void setTarih(String tarih) {
		this.Tarih = tarih;
	}

	public String getSaat() {
		return Saat;
	}

	public void setSaat(String saat) {
		this.Saat = saat;
	}

	public String getSalon() {
		return Salon;
	}

	public void setSalon(String salon) {
		this.Salon = salon;
	}
	
	public String getKoltuk() {
		return Koltuk;
	}

	public void setKoltuk(String koltuk) {
		this.Koltuk = koltuk;
	}
	
	public ArrayList<KonserBilet> getKonserBiletList() throws SQLException{
		ArrayList<KonserBilet> list = new ArrayList<>();
		KonserBilet obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM konserbilet");
			while (rs.next()) {
				obj = new KonserBilet(rs.getInt("ID"),rs.getString("konserAdi"),rs.getString("Tarih"),rs.getString("Saat"),rs.getString("Salon"),rs.getString("Koltuk"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;	
	}
	
	
	
}
