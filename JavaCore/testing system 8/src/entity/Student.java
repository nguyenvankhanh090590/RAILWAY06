package entity;



public class Student implements Comparable<Student>{
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	private int id = 0;
	private String name;
	public static int count = 0;
	
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
	
	public Student(String name) {
		super();
		count++;
		this.id = count;
		this.name = name;
	}
	public Student() {
		super();
		count++;
		this.id = count;
	}
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Student other) {
		
		
		if (this.name.compareTo(other.name) < 0) {
			return -1;			
		} else if (this.name.compareTo(other.name) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
