package entity.Q3.Ex2;

public class HinhChuNhat {
	private float a;
	private float b;
	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	public float tinhChuvi(float a, float b) {
		return (a+b)*2;
	}	
	public float tinhDienTich(float a, float b) {
		return a*b;
	}
	
}
