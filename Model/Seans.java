package Model;



public class Seans {
	//filmId bakilacak
	private String date;
	private String time;
	private int seansId;
	
	public Seans(String date, String time, int seansId) {
		super();
		this.date = date;
		this.time = time;
		this.seansId = seansId;
	}
	
	/*public Seans(String date, String time, int seansId,int filmId) {
		super();
		this.date = date;
		this.time = time;
		this.seansId = seansId;
		this.filmId = filmId;		;
		
	}*/

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public int getSeansId() {
		return seansId;
	}
	
	
	
	
}

