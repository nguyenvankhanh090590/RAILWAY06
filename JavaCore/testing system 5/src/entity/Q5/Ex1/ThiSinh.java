package entity.Q5.Ex1;

public class ThiSinh {
	private int sbd;
	private String fullName;
	private String address;
	private int priolevel;
	private String khoiThi;

	public int getSbd() {
		return sbd;
	}

	public void setSbd(int sbd) {
		this.sbd = sbd;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPriolevel() {
		return priolevel;
	}

	public void setPriolevel(int priolevel) {
		this.priolevel = priolevel;
	}

	
	public String getKhoiThi() {
		return khoiThi;
	}

	public void setKhoiThi(String khoiThi) {
		this.khoiThi = khoiThi;
	}

	public ThiSinh(int sbd, String fullName, String address, int priolevel) {
		super();
		this.sbd = sbd;
		this.fullName = fullName;
		this.address = address;
		this.priolevel = priolevel;
	}

	public ThiSinh() {
		super();
	}

	@Override
	public String toString() {
		return "ThiSinh [sbd=" + sbd + ", fullName=" + fullName + ", address=" + address + ", priolevel=" + priolevel
				+ ", khoiThi=" + khoiThi + "]";
	}
	
}
