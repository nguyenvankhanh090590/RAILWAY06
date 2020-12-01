package entity.Q4.Ex5;

public class Bao extends TaiLieu {
	private String ngayPhatHanh;

	public Bao(int id, String nXB, int numPub, String ngayPhatHanh) {
		super(id, nXB, numPub);
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public Bao() {
		
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		return "Bao [ngayPhatHanh=" + ngayPhatHanh + "]";
	}
	
	
}
