package entity;
import entity.Configs;
public abstract class HinhHoc {
	public static int count = 0;
	public abstract float tinhChuVi();
	public abstract float tinhDienTich();
	
	public HinhHoc() throws HinhHocException {
		super ();
		count ++;
		this.check();
	}
	public void check() throws HinhHocException {
		if (count > Configs.SO_HINH_TOI_DA) {
			throw new HinhHocException("Số lượng hình tối đa là: " + Configs.SO_HINH_TOI_DA);
		}
	}
}
