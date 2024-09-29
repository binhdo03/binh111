package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import model.TheLoai;



public class theLoaiDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	
	public List<TheLoai> getAllTheLoai(){
		ArrayList<TheLoai> list= new ArrayList<TheLoai>();
		String query="select * from theloai";
		try {
			
			conn= JDBCUtil.getConnection();
			ps= conn.prepareStatement(query);
			rs= ps.executeQuery();	
			
			while(rs.next()) {
				list.add(new TheLoai(rs.getString(1),
						rs.getString(2)));
				
			}
			
			JDBCUtil.closeConnection(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		theLoaiDAO pro= new theLoaiDAO();
		List<TheLoai> list = pro.getAllTheLoai();
		for (TheLoai theLoai : list) {
			System.out.print(theLoai);
			System.out.println();
		}
	}
}
