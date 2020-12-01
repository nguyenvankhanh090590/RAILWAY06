package entity.Q4.Ex5;

public class TaiLieu {
	private int id;
	private String NXB;
	private int numPub;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public int getNumPub() {
		return numPub;
	}
	public void setNumPub(int numPub) {
		this.numPub = numPub;
	}
	public TaiLieu(int id, String nXB, int numPub) {
		super();
		this.id = id;
		NXB = nXB;
		this.numPub = numPub;
	}
	public TaiLieu() {
		super();
	}
	@Override
	public String toString() {
		return "TaiLieu [id=" + id + ", NXB=" + NXB + ", NumPub=" + numPub + "]";
	}
	
	
}
