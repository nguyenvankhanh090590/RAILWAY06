package entity.Q1.Ex6;

public abstract class Phone {
	private String name;
	private String number;
	private Phone[] contacts;
	
	public Phone[] getContacts() {
		return contacts;
	}
	public void setContacts(Phone[] contacts) {
		this.contacts = contacts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Phone(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public Phone() {
		super();
	}
	
	abstract void insertContact(String name, String phone);
	abstract void removeContact(String name);
	abstract void updateContact(String name, String newPhone);
	abstract void searchContact(String name);
}
