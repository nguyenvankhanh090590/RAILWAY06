package entity.Q5.Ex1;

import java.util.Scanner;

public class KhoiC extends ThiSinh {
	private float Literature;
	private float History;
	private float Geography;
	public float getLiterature() {
		return Literature;
	}
	
	public float getHistory() {
		return History;
	}
	
	public float getGeogaphy() {
		return Geography;
	}
	
	
	
	
	public KhoiC(int sbd, String fullName, String address, int priolevel) {
		super(sbd, fullName, address, priolevel);
	}

	public KhoiC() {
		super();
	}
	public void addScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập điểm văn");
		this.Literature=sc.nextFloat();
		System.out.println("Mời nhập điểm sử");
		this.History = sc.nextFloat();
		System.out.println("Mời nhập điểm địa");
		this.Geography = sc.nextFloat();
	}

	@Override
	public String toString() {
		return "KhoiC [Literature=" + Literature + ", History=" + History + ", Geography=" + Geography + ", Sbd="
				+ getSbd() + ", FullName=" + getFullName() + ", Address=" + getAddress() + ", Priolevel="
				+ getPriolevel() + "]";
	}

	

	
	
}
