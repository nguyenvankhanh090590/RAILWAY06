package entity;

import java.time.LocalDate;

public class Account {
	@Override
	public String toString() {
		if (dept == null) {
			return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
					+ ", gender=" + gender + ", department=" +" null"+", position="+ posi.getPosiName()+ ", createDate=" + createDate + "]";
		} else if (posi == null) {
			return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
					+ ", gender=" + gender + ", department=" + dept.getName()+", position="+" null" + ", createDate=" + createDate + "]";
		} else {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", gender=" + gender + ", department=" + dept.getName()+", position="+ posi.getPosiName()+ ", createDate=" + createDate + "]";
		}
	}

	private int id;
	private String email;
	private String username;
	private String fullName;
	private String gender;
	private Department dept;
	private Position posi;
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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Position getPosi() {
		return posi;
	}

	public void setPosi(Position posi) {
		this.posi = posi;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Account(int id, String email, String username, String fullName, String gender, Department dept,
			Position posi, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.gender = gender;
		this.dept = dept;
		this.posi = posi;
		this.createDate = createDate;
	}

	public Account() {
		super();
	}
	
	
	
}
