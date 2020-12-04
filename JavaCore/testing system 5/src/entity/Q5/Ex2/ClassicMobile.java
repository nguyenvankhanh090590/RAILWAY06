package entity.Q5.Ex2;

public class ClassicMobile extends MobilePhone implements IWeapon {

	
	private String listenToRadio;
	
	
	public ClassicMobile(String listen, String call, String sendMess, String receiveMess) {
		super(listen, call, sendMess, receiveMess);
	}


	public String getListenToRadio() {
		return listenToRadio;
	}



	public void setListenToRadio(String listenToRadio) {
		this.listenToRadio = listenToRadio;
	}



	@Override
	public void attackEnermy() {
		System.out.println("Rarely");
	}

	@Override
	public void throwToEnermy() {
		System.out.println("Great idea!");
	}

}
