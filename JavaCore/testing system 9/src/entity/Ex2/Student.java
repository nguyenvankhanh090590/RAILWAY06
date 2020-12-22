package entity.Ex2;

public class Student {

	/**
	 * 
	 * @deprecated version đã lỗi thời
	 */
	@Deprecated
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}

	public String getIdV2() {
		return "MSV: " + id;
	}
}
