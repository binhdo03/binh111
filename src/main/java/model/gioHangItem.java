package model;

public class gioHangItem {
    private SanPham sanPham;
    private int soLuong;
    
    public gioHangItem(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    
    public SanPham getSanPham() {
        return sanPham;
    }
    
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public boolean addSoLuong(int soLuong) {
    	this.soLuong+=soLuong;
    	return true;
    }
    public double getTongTien() {
    	return this.soLuong*this.sanPham.getGiaBan();
    }
}
