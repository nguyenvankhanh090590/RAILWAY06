package entity.Ex2;

import java.time.LocalDate;


public class Student implements Comparable<Student> {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", score=" + score + "]";
	}
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	private int id;
	private String name;
	private LocalDate birthDate;
	private float score;
	
	public Student(int id, String name, LocalDate birthDate, float score) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student o) {
		if (this.name.compareTo(o.name) < 0) {
			return -1;
		} else if (this.name.compareTo(o.name) > 0) {
			return 1;
		} else if (this.name.compareTo(o.name) == 0 && this.birthDate.compareTo(o.birthDate) < 0) {
			return -1;
		} else if (this.name.compareTo(o.name) == 0 && this.birthDate.compareTo(o.birthDate) > 0) {
			return 1;
		} else if (this.name.compareTo(o.name) == 0 && this.birthDate.compareTo(o.birthDate) == 0 && this.score < o.score) {
			return -1;
		} else if (this.name.compareTo(o.name) == 0 && this.birthDate.compareTo(o.birthDate) == 0 && this.score > o.score) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	
	
}
