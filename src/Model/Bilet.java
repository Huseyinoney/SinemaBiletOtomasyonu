package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.DBConnection;

public class Bilet {
	
	static DBConnection conn = new DBConnection();
	static Connection con = DBConnection.DBCon();
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement preparedStatement = null;
	private int biletId;
	private String FilmAdi;
	private String seans;
	private String koltukNumara;
	private String musteri;
	
	public Bilet(int biletId, String filmAdi, String seans, String koltukNumara, String musteri) {
		super();
		this.biletId = biletId;
		FilmAdi = filmAdi;
		this.seans = seans;
		this.koltukNumara = koltukNumara;
		this.musteri = musteri;
	}
	
	public Bilet () {}

	public int getBiletId() {
		return biletId;
	}

	public void setBiletId(int biletId) {
		this.biletId = biletId;
	}

	public String getFilmAdi() {
		return FilmAdi;
	}

	public void setFilmAdi(String filmAdi) {
		FilmAdi = filmAdi;
	}

	public String getSeans() {
		return seans;
	}

	public void setSeans(String seans) {
		this.seans = seans;
	}

	public String getKoltukNumara() {
		return koltukNumara;
	}

	public void setKoltukNumara(String koltukNumara) {
		this.koltukNumara = koltukNumara;
	}
	
	public String getMusteri() {
		return musteri;
	}

	public void setMusteri(String musteri) {
		this.musteri = musteri;
	}

	public static boolean biletKontrol(String FilmAdi, String seans, String koltukNumara) {
		boolean key = false;
		try {
			String query = "SELECT FilmAdi, seans, koltukNumara FROM bilet WHERE FilmAdi= '" + FilmAdi +  "' AND seans= '" + seans +  "' AND koltukNumara= '" + koltukNumara +  "' ";
			
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);
			rs.next();
			String ad = rs.getString("FilmAdi");
			String seansAdi = rs.getString("seans");
			String koltuk = rs.getString("koltukNumara");
			//System.out.println(rs.getString("FilmAdi"));
			//System.out.println(rs.getString("seans"));
			//System.out.println(rs.getString("koltukNumara"));
			System.out.println(rs.next());
			if (ad.equals(FilmAdi) && seansAdi.equals(seans) && koltuk.equals(koltukNumara)) {
				System.out.println("bilet kontrol true");
				key = true;
			}
			else {
				System.out.println("bilet kontrol false");
				key = false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String koltukKontrol(String FilmAdi, String seans, String koltukNumara) {
		boolean key = false;
		try {
			String query = "SELECT FilmAdi, seans, koltukNumara FROM bilet WHERE FilmAdi= '" + FilmAdi +  "' AND seans= '" + seans +  "' AND koltukNumara= '" + koltukNumara +  "' ";
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);
			rs.next();
			String ad = rs.getString("FilmAdi");
			String seansAdi = rs.getString("seans");
			String koltuk = rs.getString("koltukNumara");
			if (ad.equals(FilmAdi) && seansAdi.equals(seans) && koltuk.equals(koltukNumara)) {
				System.out.println("bilet kontrol true");
				key = true;
			}
			else {
				System.out.println("bilet kontrol false");
				key = false;
			}	
		}
		catch (Exception e){
		}
		if (key) {
			System.out.println("oldu");
			return koltukNumara;
		} else {
			System.out.println("olmadi");
			return "";
			
		}
	}
	
	public static boolean biletAl(String FilmAdi, String seans, String koltukNumara, String musteri) throws SQLException{
		int key = 0;
		String query = "INSERT INTO bilet (FilmAdi, seans, koltukNumara, musteri) VALUES (?,?,?,?)";
		try {
			//st = con.createStatement();
			//rs = st.executeQuery(query);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, FilmAdi);
			preparedStatement.setString(2, seans);
			preparedStatement.setString(3, koltukNumara);
			preparedStatement.setString(4, musteri);
			preparedStatement.executeUpdate();
			key = 1;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		if (key==1) {
			return true;
		} else {
			System.out.println("false");
			return false;
		}	
	}
}
