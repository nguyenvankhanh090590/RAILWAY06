package entity.Q1.Ex5;

public class NhanVien extends CanBo {
	private String job;
	// Khởi tạo toàn bộ thuộc tính

	public NhanVien(String fullName, int age, String gender, String address, String job) {
		super(fullName, age, gender, address);
		this.job = job;
	}
	// Khởi tạo ko có thuộc tính
	public NhanVien(String fullName, int age, String gender, String address) {
		super(fullName, age, gender, address);
	}
	//Get & Set
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
	
}
