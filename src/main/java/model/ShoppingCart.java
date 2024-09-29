package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	 private List<gioHangItem> list;

	public ShoppingCart() {
		this.list = new ArrayList<>();
		
	}
	public void add(gioHangItem gioHangItem) {
	    for (gioHangItem i : list) {
	        if (i.getSanPham().getMaSanPham().equals(gioHangItem.getSanPham().getMaSanPham())) {
	            i.addSoLuong(gioHangItem.getSoLuong());
	            return;
	        }
	    }
	    this.list.add(gioHangItem);
	}
	

	public void remove(String maSanPham) {
		for(gioHangItem c: list) {
			if(c.getSanPham().getMaSanPham().equals(maSanPham)) {
				list.remove(c);
				return;
			}
		}
		
	}
	public void update(String maSanPham,int soLuong) {
		for(gioHangItem c: list) {
			if(c.getSanPham().getMaSanPham().equals(maSanPham)) {
				c.setSoLuong(soLuong);
				return;
			}
		}
	}
	public int getSize() {
		int re=0;
		for(gioHangItem c:list) {
			re+=c.getSoLuong();
		}
		return re;
	}
	
	public List<gioHangItem> getGioHangItemList(){
		return this.list;
	}
	public double getTongGioHang() {
		double a=0;
		for(gioHangItem c: list) {
			a+=c.getTongTien();
		}
		return a;
	}
	public String getVat() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return decimalFormat.format(this.getTongGioHang()*0.1);
	}
	public double getTongThanhToan() {
	    double tongGioHang = getTongGioHang(); 
	    double vat = tongGioHang * 0.1; 
	    return tongGioHang + vat; 
	}

	
}
