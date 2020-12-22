package entity;

public class HinhTron extends HinhHoc {
	private static final float Pi = 3.14f;
	private float radius;
	public static int countHT = 0;

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public static float getPi() {
		return Pi;
	}

	@Override
	public float tinhChuVi() {
		return 2*Pi*radius;
	}

	@Override
	public float tinhDienTich() {
		return (float) (Pi*Math.pow(radius, 2));
	}

	public HinhTron(float radius) throws HinhHocException {
		super();
		this.radius = radius;
		countHT ++;
	}
	
}
