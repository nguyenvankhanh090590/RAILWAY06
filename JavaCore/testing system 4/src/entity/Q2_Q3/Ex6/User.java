package entity.Q2_Q3.Ex6;


public abstract  class User {
	private String name;
	protected double salaryRatio;
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", salaryRatio=" + salaryRatio + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalaryRatio() {
		return salaryRatio;
	}
	public void setSalaryRatio(double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	
	public User(String name, double salaryRatio) {
		super();
		this.name = name;
		this.salaryRatio = salaryRatio;
	}
	
	public abstract double calculatePay();
	
	public void displayInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Salary ratio: " + this.salaryRatio);
		System.out.println("Pay: " + this.calculatePay());
	}
	
}
