package entity.Q2_Q3.Ex6;

public class Employee extends User {

	
	public Employee(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return this.salaryRatio*420;
	}

}
