package entity.Q3.Ex2;

public class HinhVuong extends HinhChuNhat {
	private float edge;
	
	
	public float getA() {
		return edge;
	}
	public void setA(float edge) {
		this.edge = edge;
	}
	
	public float tinhChuVi() {
		return super.tinhChuvi(edge, edge);
	}
	 public float tinhDienTich() {
		 return super.tinhDienTich(edge, edge);
	 }
	
}
