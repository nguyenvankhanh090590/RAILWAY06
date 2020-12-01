package entity.Q3Ex5;

public class HighSchoolStudent extends Student {
	private String clazz;
	private String desiredUniversity;

	// Khởi tạo tất cả các thuộc tính
	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}
	// Khởi tạo không thuộc tính nào

	public HighSchoolStudent() {

	}
	// Get & Set

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDesiredUniversity() {
		return desiredUniversity;
	}

	public void setDesiredUniversity(String desiredUniversity) {
		this.desiredUniversity = desiredUniversity;
	}

	// set toString()
	@Override
	public String toString() {
		return "HighSchoolStudent [clazz=" + clazz + ", desiredUniversity=" + desiredUniversity + ", getId()=" + getId()
				+ ", getName()=" + getName() + "]";
	}

}
