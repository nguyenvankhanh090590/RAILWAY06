package entity.Q2.Ex2;

import java.time.LocalDate;

public class Person {
	private String name;
	private String gender;
	private String address;
	private LocalDate birthDate;
	
	public Person(String name, String gender, String address, LocalDate birthDate) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birthDate = birthDate;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", address=" + address + ", birthDate=" + birthDate
				+ "]";
	}
	
	
	
}
