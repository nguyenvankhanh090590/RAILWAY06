package entity;

import java.time.LocalDate;

public class Account {
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", gender=" + gender + ", department_id=" + department_id + ", position_id=" + position_id
				+ ", createDate=" + createDate + "]";
	}

	private int id;
	private String email;
	private String username;
	private String fullName;
	private String gender;
	private int department_id;
	private int position_id;
	private LocalDate createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Account(int id, String email, String username, String fullName, String gender, int department_id,
			int position_id, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.gender = gender;
		this.department_id = department_id;
		this.position_id = position_id;
		this.createDate = createDate;
	}

	public Account() {
		super();
	}
	
	
	
}
