package entity.Q2.Ex2;

import java.time.LocalDate;

public class Student extends Person {
	private String id;
	private String email;
	private float AvgScore;
	
	public Student(String name, String gender, String address, LocalDate birthDate, String id, String email,
			float avgScore) {
		super(name, gender, address, birthDate);
		this.id = id;
		this.email = email;
		AvgScore = avgScore;
	}

	public Student() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getAvgScore() {
		return AvgScore;
	}

	public void setAvgScore(float avgScore) {
		AvgScore = avgScore;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", AvgScore=" + AvgScore + ", getName()=" + getName()
				+ ", getGender()=" + getGender() + ", getAddress()=" + getAddress() + ", getBirthDate()="
				+ getBirthDate() + "]";
	}

	
	
	
	
	
	
	
}
