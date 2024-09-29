package model;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String hinhAnh;
	private double giaBan;
	private String mota;
	private String xuatXu;
	public SanPham(String maSanPham, String tenSanPham, String hinhAnh, double giaBan, String mota, String xuatXu) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.hinhAnh = hinhAnh;
		this.giaBan = giaBan;
		this.mota = mota;
		this.xuatXu = xuatXu;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", hinhAnh=" + hinhAnh + ", giaBan="
				+ giaBan + ", mota=" + mota + ", xuatXu=" + xuatXu + "]";
	}
	
	
	
	
}
