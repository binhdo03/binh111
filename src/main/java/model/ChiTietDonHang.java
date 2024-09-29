package model;

public class ChiTietDonHang {
	private String maChiTietDon;
	private DonHang donHang;
	private SanPham maSanPham;
	private int soLuong;
	private double giaSanPham;
	private double giamGia;
	private double vat;
	private double tongTien;
	
	
	public ChiTietDonHang() {
	}


	public ChiTietDonHang(String maChiTietDon, DonHang donHang, SanPham maSanPham, int soLuong, double giaSanPham,
			double giamGia, double vat, double tongTien) {		
		this.maChiTietDon = maChiTietDon;
		this.donHang = donHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.giaSanPham = giaSanPham;
		this.giamGia = giamGia;
		this.vat = vat;
		this.tongTien = tongTien;
	}


	public String getMaChiTietDon() {
		return maChiTietDon;
	}


	public void setMaChiTietDon(String maChiTietDon) {
		this.maChiTietDon = maChiTietDon;
	}


	public DonHang getDonHang() {
		return donHang;
	}


	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}


	public SanPham getMaSanPham() {
		return maSanPham;
	}


	public void setMaSanPham(SanPham    maSanPham) {
		this.maSanPham = maSanPham;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public double getGiaSanPham() {
		return giaSanPham;
	}


	public void setGiaSanPham(double giaSanPham) {
		this.giaSanPham = giaSanPham;
	}


	public double getGiamGia() {
		return giamGia;
	}


	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}


	public double getVat() {
		return vat;
	}


	public void setVat(double vat) {
		this.vat = vat;
	}


	public double getTongTien() {
		return tongTien;
	}


	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	
	
}
