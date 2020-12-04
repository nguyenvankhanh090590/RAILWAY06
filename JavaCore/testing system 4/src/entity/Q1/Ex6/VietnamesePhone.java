package entity.Q1.Ex6;

public class VietnamesePhone extends Phone {

	public VietnamesePhone() {
	}
	
	@Override
	void insertContact(String name, String phone) {
		System.out.println("Insert new contact with " + name + " and phone " + phone);		
	}

	@Override
	void removeContact(String name) {
		System.out.println("Removing contact with name :" + name);		
	}

	@Override
	void updateContact(String name, String newPhone) {
		System.out.println("Update contact " + name + " with new phone " + newPhone);		
	}

	@Override
	void searchContact(String name) {
		System.out.println("Search contact " + name + "...");		
	}

}
