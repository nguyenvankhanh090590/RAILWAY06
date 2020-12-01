package entity.Ex1;

import java.time.LocalDateTime;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private Department departmentID;
	private int positionID;
	private LocalDateTime createDate;
	private Group[] groups;

//	a, Không có parameters
	public Account() {
		super();
	}

//	b) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)
	public Account(int id, String email, String username, String firstName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
	}

//	c) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, default createDate = now
	public Account(int id, String email, String username, String firstName, String lastName, int positionID) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.positionID = positionID;
		this.createDate = LocalDateTime.now();
	}

//	d) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, createDate
	public Account(int id, String email, String username, String firstName, String lastName, int positionID,
			LocalDateTime createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.positionID = positionID;
		this.createDate = createDate;
	}

	// Get & Set
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

	public Department getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	// totring()
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName
				+ ", departmentID=" + departmentID + ", positionID=" + positionID + ", createDate=" + createDate + "]";
	}

	
	
	
	

}
