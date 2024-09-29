package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tenDangNhap=request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		
		// Trong servlet hoặc controller
		
		KhachHangDAO kh = new KhachHangDAO();
		KhachHang user = kh.selectByAccAndPass(tenDangNhap, matKhau);
		
		if (user == null) {
		    request.setAttribute("saiTaiKhoan", "Tài khoản hoặc mật khẩu không chính xác!");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
		    HttpSession session = request.getSession();
		    session.setAttribute("acc", user);
		    int phanQuyen = user.getPhanQuyen();
		    response.sendRedirect(request.getContextPath() + "/home");
		}

		
		
	}

}
