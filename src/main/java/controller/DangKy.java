package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "DangKy", urlPatterns = { "/dang-ky" })
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String dienThoai= request.getParameter("dienThoai");
		String email= request.getParameter("email");
		String dongYDieuKhoan= request.getParameter("dongYDieuKhoan");
		
		request.setAttribute("tenDangNhap",tenDangNhap);
		request.setAttribute("matKhau",matKhau);
		request.setAttribute("matKhauNhapLai",matKhauNhapLai);
		request.setAttribute("hoVaTen",hoVaTen);
		request.setAttribute("ngaySinh",ngaySinh);
		request.setAttribute("gioiTinh",gioiTinh);
		request.setAttribute("diaChi",diaChi );
		request.setAttribute("dienThoai",dienThoai);
		request.setAttribute("email",email);
		request.setAttribute("dongYDieuKhoan",dongYDieuKhoan);
		
		
		
		String url="";
		KhachHangDAO KhachHangDao= new KhachHangDAO();
		if(KhachHangDao.kiemTraTenDangNhap(tenDangNhap)) {
			request.setAttribute("error", "Tài Khoản đã tồn tại!");
			request.getRequestDispatcher("/dangki.jsp").forward(request, response);
		}else {
			Random rd= new Random();
			String maKhachHang="KH"+ System.currentTimeMillis()+rd.nextInt(100)+"";
			
			KhachHang kh = new KhachHang( maKhachHang,tenDangNhap,matKhau,hoVaTen, gioiTinh, diaChi,Date.valueOf(ngaySinh),dienThoai,email,0);
			KhachHangDao.insert(kh);
			url="/success.jsp";
		}
		RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}