package entity.Q4.Ex5;

public class TapChi extends TaiLieu {
	private String soPhatHanh;
	private String thangPhatHanh;
	
	public TapChi(int id, String nXB, int numPub, String soPhatHanh, String thangPhatHanh) {
		super(id, nXB, numPub);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}

	public TapChi() {
		super();
	}

	public String getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(String soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public String getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(String thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "TapChi [soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + "]";
	}
	
	
}
