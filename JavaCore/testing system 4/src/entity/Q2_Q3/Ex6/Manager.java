package entity.Q2_Q3.Ex6;

public class Manager extends User{

	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return this.salaryRatio*520;
	}

}
