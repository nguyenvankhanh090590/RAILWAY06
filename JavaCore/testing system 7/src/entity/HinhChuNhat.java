package entity;

public class HinhChuNhat extends HinhHoc {
	private float length;
	private float width;
	public static int countHCN = 0;
	
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	@Override
	public float tinhChuVi() {
		return 2*(length+width);
	}
	@Override
	public float tinhDienTich() {
		return length*width;
	}
	public HinhChuNhat(float length, float width) throws HinhHocException {
		super();
		this.length = length;
		this.width = width;
		countHCN ++;
	}
	
	
	
	
}
