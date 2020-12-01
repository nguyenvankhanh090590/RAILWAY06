package entity.Ex1;


import java.time.LocalDateTime;

public class Group {
	private short id;
	private String name;
	private Account creatorID;
	private LocalDateTime createDate;
	private Account[] accountIDs;
	private Account username;
	// ko có thuộc tính
	public Group() {
		super();
	}
	// b,
	public Group(String name, Account creatorID, Account[] accountIDs, LocalDateTime createDate) {
		super();
		this.name = name;
		this.creatorID = creatorID;
		this.createDate = createDate;
		this.accountIDs = accountIDs;
		this.username = creatorID;
	}
	// c, 
	public Group(String name, Account creatorID, Account username, Account[] accountIDs, LocalDateTime createDate) {
		super();
		this.name = name;
		this.creatorID = creatorID;
		this.createDate = createDate;
		this.accountIDs = accountIDs;
		this.username = username;
	}
	//get&Set
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreatorID() {
		return creatorID.getId();
	}
	public void setCreatorID(Account creatorID) {
		this.creatorID = creatorID;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Account[] getAccountIDs() {
		return accountIDs;
	}
	public void setAccountIDs(Account[] accountIDs) {
		this.accountIDs = accountIDs;
	}
	public String getUsername() {
		return username.getUsername();
	}
	public void setUsername(Account username) {
		this.username = username;
	}
	// toString()
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creatorID=" + creatorID.getId() + ", createDate=" + createDate
				+ ", username=" + username.getUsername() + "]";
	}
	
}
