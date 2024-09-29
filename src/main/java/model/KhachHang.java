package model;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private	String matKhau;
	private String tenKhachHang;
	private String gioiTinh;
	private String diaChi;
	private Date ngaySinh;
	private String sdt;
	private String email;
	private int phanQuyen;
	
	
	
	public KhachHang() {
	}



	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String tenKhachHang, String gioiTinh,
			String diaChi, Date ngaySinh, String sdt, String email, int phanQuyen) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.phanQuyen = phanQuyen;
	}



	public String getMaKhachHang() {
		return maKhachHang;
	}



	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}



	public String getTenDangNhap() {
		return tenDangNhap;
	}



	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}



	public String getMatKhau() {
		return matKhau;
	}



	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}



	public String getTenKhachHang() {
		return tenKhachHang;
	}



	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}



	public String getGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public Date getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public String getSdt() {
		return sdt;
	}



	public void setSdt(String sdt) {
		this.sdt = sdt;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getPhanQuyen() {
		return phanQuyen;
	}



	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}


	
	
	
}
