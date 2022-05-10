package Model;

public class Salon {

	private int salonId;
	private String salonName;
	private int seatId;
	private String seatNumber;
	private int seansId;
	
	public Salon(int salonId, String salonName, int seatId, String seatNumber, int seansId) {
		super();
		this.salonId = salonId;
		this.salonName = salonName;
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seansId = seansId;
	}

	public int getSalonId() {
		return salonId;
	}

	public String getSalonName() {
		return salonName;
	}

	public int getSeatId() {
		return seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public int getSeansId() {
		return seansId;
	};
	
	
	
	
}
