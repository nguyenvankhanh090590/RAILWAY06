package entity.Q5.Ex1;

import java.util.Scanner;

public class KhoiA extends ThiSinh {
	private float Math;
	private float Physic;
	private float Chemistry;
	public float getMath() {
		return Math;
	}
	
	public float getPhysic() {
		return Physic;
	}
	
	public float getChemistry() {
		return Chemistry;
	}
	
	
	
	
	

	public KhoiA(int sbd, String fullName, String address, int priolevel) {
		super(sbd, fullName, address, priolevel);
	}

	public KhoiA() {
		super();
	}
	
	public void addScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập điểm toán");
		this.Math=sc.nextFloat();
		System.out.println("Mời nhập điểm lý");
		this.Physic = sc.nextFloat();
		System.out.println("Mời nhập điểm hóa");
		this.Chemistry = sc.nextFloat();
		
	}

	@Override
	public String toString() {
		return "Khoi A[Math=" + Math + ", Physic=" + Physic + ", Chemistry=" + Chemistry + ", Sbd=" + getSbd()
				+ ", FullName=" + getFullName() + ", Address=" + getAddress() + ", Priolevel="
				+ getPriolevel() + "]";
	}

	

	
	
	
}
