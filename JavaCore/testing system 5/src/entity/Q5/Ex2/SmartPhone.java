package entity.Q5.Ex2;

public class SmartPhone extends MobilePhone implements IWeapon {

	

	private String Use3G_4G_5G;
	private String camera;
	
	public SmartPhone(String listen, String call, String sendMess, String receiveMess) {
		super(listen, call, sendMess, receiveMess);
	}
	

	public String getUse3G_4G_5G() {
		return Use3G_4G_5G;
	}



	public void setUse3G_4G_5G(String use3g_4g_5g) {
		Use3G_4G_5G = use3g_4g_5g;
	}



	public String getCamera() {
		return camera;
	}



	public void setCamera(String camera) {
		this.camera = camera;
	}



	@Override
	public void attackEnermy() {
		System.out.println("Explode and burn enermy");

	}

	@Override
	public void throwToEnermy() {
		System.out.println("Rarely");

	}

}
