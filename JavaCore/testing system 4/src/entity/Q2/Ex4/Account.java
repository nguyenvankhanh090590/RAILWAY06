package entity.Q2.Ex4;

public class Account {
	private int id;
	private String name;
	private int balance;
	
	public Account(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int credit(int amount) {
		return amount;
	}
	
	public int debit(int amount) {
		return amount;
	}
	
	public Account tranferTo(Account acc,int amount ) {
		acc.balance = amount;
		return acc;
	}
}
