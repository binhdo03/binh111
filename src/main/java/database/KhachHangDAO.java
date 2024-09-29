package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import model.KhachHang;
import model.SanPham;

public class KhachHangDAO {
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, tenkhachhang, gioitinh, diachi, ngaysinh, sdt, email,id) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			st.setString(2, t.getTenDangNhap());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getTenKhachHang());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setDate(7, t.getNgaySinh());
			st.setString(8, t.getSdt());
			st.setString(9, t.getEmail());
			st.setInt(10,t.getPhanQuyen());
			

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public KhachHang selectByAccAndPass(String taiKhoan, String pass) {
		KhachHang kq= null;
		try {
			// Bước 1: tạo kết nối đến CSDL
						Connection con = JDBCUtil.getConnection();

						// Bước 2: tạo ra đối tượng statement
						String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau=?";
						PreparedStatement st = con.prepareStatement(sql);
						st.setString(1,taiKhoan);
						st.setString(2,pass);

						// Bước 3: thực thi câu lệnh SQL
						System.out.println(sql);
						ResultSet rs = st.executeQuery();
						
						while(rs.next()) {
							kq= new KhachHang(rs.getString(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getDate(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10));
							
						}
						JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kq;
	}

	
	public class MainTest {
	    public static void main(String[] args) {
	        // Tạo một đối tượng KhachHang để thêm vào CSDL
	        KhachHang khachHang = new KhachHang();
	        khachHang.setMaKhachHang("KH001");
	        khachHang.setTenDangNhap("test123");
	        khachHang.setMatKhau("123456");
	        khachHang.setTenKhachHang("Nguyễn Văn A");
	        khachHang.setGioiTinh("Nam");
	        khachHang.setDiaChi("123 Đường ABC, Quận XYZ, Thành phố HCM");
	        khachHang.setNgaySinh(Date.valueOf("1990-01-01"));
	        khachHang.setSdt("0123456789");
	        khachHang.setEmail("abc@example.com");
	        khachHang.setPhanQuyen(1); // Giả sử phân quyền 1 là người dùng thường

	        // Tạo một đối tượng của lớp KhachHangDAO
	        KhachHangDAO khachHangDAO = new KhachHangDAO();

	        // Gọi phương thức insert và chạy thử
	        khachHangDAO.insert(khachHang);
	    }
	}
}
