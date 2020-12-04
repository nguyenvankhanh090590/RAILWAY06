package entity.Q1.Ex5;

public class KySu extends CanBo {
	private String nganhDaoTao;
	// Khởi tạo toàn bộ thuộc tính

	public KySu(String fullName, int age, String gender, String address, String nganhDaoTao) {
		super(fullName, age, gender, address);
		this.nganhDaoTao = nganhDaoTao;
	}
	// Khởi tạo ko có thuộc tính
	public KySu(String fullName, int age, String gender, String address) {
		super(fullName, age, gender, address);
	}
	// Get & Set
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}
	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
	
}
