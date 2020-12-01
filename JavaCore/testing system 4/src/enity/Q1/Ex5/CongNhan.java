package enity.Q1.Ex5;

public class CongNhan extends CanBo {
	private int position;
// Khởi tạo toàn bộ thuộc tính
	public CongNhan(String fullName, int age, String gender, String address, int position) {
		super(fullName, age, gender, address);
		this.position = position;
	}
// Khởi tạo ko có thuộc tính
	public CongNhan(String fullName, int age, String gender, String address) {
		super(fullName, age, gender, address);
	}
// Get & Set
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
