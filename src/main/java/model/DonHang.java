package model;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiNhanHang;
	private String trangThaiDonHang;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double soTienDonHang;
	private String ngayDatHang;
	private String ngayNhanHang;
	
	
	
	public DonHang() {
	}



	public DonHang(String maDonHang, KhachHang khachHang, String diaChiNhanHang, String trangThaiDonHang,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienDonHang, String ngayDatHang,
			String ngayNhanHang) {
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThaiDonHang = trangThaiDonHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienDonHang = soTienDonHang;
		this.ngayDatHang = ngayDatHang;
		this.ngayNhanHang = ngayNhanHang;
	}



	public String getMaDonHang() {
		return maDonHang;
	}



	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}



	public KhachHang getKhachHang() {
		return khachHang;
	}



	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}



	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}



	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}



	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}



	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}



	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}



	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}



	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}



	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}



	public double getSoTienDonHang() {
		return soTienDonHang;
	}



	public void setSoTienDonHang(double soTienDonHang) {
		this.soTienDonHang = soTienDonHang;
	}



	public String getNgayDatHang() {
		return ngayDatHang;
	}



	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}



	public String getNgayNhanHang() {
		return ngayNhanHang;
	}



	public void setNgayNhanHang(String ngayNhanHang) {
		this.ngayNhanHang = ngayNhanHang;
	}
	
	
	
}
