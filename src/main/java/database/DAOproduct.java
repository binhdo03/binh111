package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.SanPham;

public class DAOproduct {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	
	public List<SanPham> getAllSanPham(){
		ArrayList<SanPham> list= new ArrayList<SanPham>();
		String query="select * from sanpham";
		try {
			
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			rs= ps.executeQuery();	
			
			while(rs.next()) {
				list.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6)));
			}
			
			JDBCUtil.closeConnection(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getSanPhamById(String id){
		ArrayList<SanPham> list= new ArrayList<SanPham>();
		String query="select * from sanpham where matheloai=?";
		try {
			
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, id);
			rs= ps.executeQuery();	
			
			while(rs.next()) {
				list.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6)));
			}
			
			JDBCUtil.closeConnection(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public SanPham getSanPhamByIdTT(String id){
		
		String query="select * from sanpham where masanpham=?";
		try {
			
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, id);
			rs= ps.executeQuery();	
			
			while(rs.next()) {
				 return (new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),		
						rs.getString(6)));
			}
			
			JDBCUtil.closeConnection(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public List<SanPham> getSanPhamByName(String seach){
		ArrayList<SanPham> list= new ArrayList<SanPham>();
		String query="SELECT * FROM sanpham\r\n"
				+ "WHERE tensanpham LIKE ?";
		try {
			
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, "%"+seach+"%");
			rs= ps.executeQuery();	
			
			while(rs.next()) {
				list.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6)));
			}
			
			JDBCUtil.closeConnection(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteProduct(String idSanPham) {
		String query ="DELETE FROM sanpham WHERE masanpham= ?";
		try {
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, idSanPham);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void insertProduct (String maSanpham, String tenSanPham, String hinhAnh,Double giaBan,String moTa,String xuatXu,String theLoai) {
			String query="INSERT INTO sanpham (masanpham,tensanpham,hinhanh,giaban,"
					+ "  mota,xuatxu,matheloai) "
					+ " VALUES (?,?,?,?,?,?,?)";
			try {
				conn= JDBCUtil.getConnection();
				ps= conn.prepareStatement(query);
				ps.setString(1, maSanpham);
				ps.setString(2, tenSanPham);
				ps.setString(3, hinhAnh);
				ps.setDouble(4, giaBan);
				ps.setString(5, moTa);
				ps.setString(6, xuatXu);
				ps.setString(7, theLoai);
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public void updateProduct(String maSanPham, String tenSanPham, String hinhAnh, Double giaBan, String moTa, String xuatXu) {
        String query = "UPDATE sanpham SET tensanpham = ?, hinhanh = ?, giaban = ?, mota = ?, xuatxu = ? WHERE masanpham = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, tenSanPham);
            ps.setString(2, hinhAnh);
            ps.setDouble(3, giaBan);
            ps.setString(4, moTa);
            ps.setString(5, xuatXu);
            ps.setString(6, maSanPham);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		DAOproduct pro= new DAOproduct();
		List<SanPham> list = pro.getAllSanPham();
		for (SanPham sanPham : list) {
			System.out.print(sanPham);
			System.out.println();
		}
	}
	
}
