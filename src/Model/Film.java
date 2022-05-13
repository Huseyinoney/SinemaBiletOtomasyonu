package Model;



public class Film {
	
	private int filmId;
	private String filmName;
	private String type;
	private String image;
	
	public Film(int filmId, String filmName, String type, String image) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
