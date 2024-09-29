package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAOproduct;

/**
 * Servlet implementation class addSanPham
 */
@WebServlet("/addSanPham")
public class addSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String maSanPham= request.getParameter("maSanPham");
		String tenSanPham= request.getParameter("tenSanPham");
		String hinhAnh= request.getParameter("hinhAnh");
		String giaBanStr= request.getParameter("giaBan");
		 double giaBan= Double.parseDouble(giaBanStr);
		String xuatXu= request.getParameter("xuatXu");
		String moTa= request.getParameter("moTa");
		String theLoai= request.getParameter("theLoai");
		
		DAOproduct pro= new DAOproduct();
		pro.insertProduct(maSanPham, tenSanPham, hinhAnh, giaBan, moTa, xuatXu, theLoai);
		response.sendRedirect("quanLySanPham");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
