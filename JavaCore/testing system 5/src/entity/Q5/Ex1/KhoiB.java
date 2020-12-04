package entity.Q5.Ex1;

import java.util.Scanner;

public class KhoiB extends ThiSinh {
	private float Math;
	private float Chemistry;
	private float Biology;
	public float getMath() {
		return Math;
	}
	
	public float getChemistry() {
		return Chemistry;
	}
	
	public float getBiology() {
		return Biology;
	}
	
	
	
	
	
	public KhoiB(int sbd, String fullName, String address, int priolevel) {
		super(sbd, fullName, address, priolevel);
	}

	public KhoiB() {
		super();
	}
	public void addScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập điểm toán");
		this.Math=sc.nextFloat();
		System.out.println("Mời nhập điểm hóa");
		this.Chemistry = sc.nextFloat();
		System.out.println("Mời nhập điểm sinh");
		this.Biology = sc.nextFloat();
	}

	@Override
	public String toString() {
		return "KhoiB [Math=" + Math + ", Chemistry=" + Chemistry + ", Biology=" + Biology + ", Sbd=" + getSbd()
				+ ", FullName=" + getFullName() + ", Address=" + getAddress() + ", Priolevel="
				+ getPriolevel() + "]";
	}

	

	
	
}
