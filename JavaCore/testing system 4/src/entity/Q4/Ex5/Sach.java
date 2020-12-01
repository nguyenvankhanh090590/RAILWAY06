package entity.Q4.Ex5;

public class Sach extends TaiLieu {
	private String autherName;
	private int numPage;
	
	
	public Sach(int id, String nXB, int numPub, String autherName, int numPage) {
		super(id, nXB, numPub);
		this.autherName = autherName;
		this.numPage = numPage;
	}
	public Sach() {
		
	}
	@Override
	public String toString() {
		return "Sach [autherName=" + autherName + ", numPage=" + numPage + "]";
	}
	public String getAutherName() {
		return autherName;
	}
	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	
	
}
