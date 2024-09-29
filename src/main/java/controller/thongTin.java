package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAOproduct;
import database.theLoaiDAO;
import model.SanPham;
import model.TheLoai;

/**
 * Servlet implementation class thongTin
 */
@WebServlet("/thongTin")
public class thongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thongTin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String maSanPham= request.getParameter("maSanPham");
		
		
		DAOproduct pro= new DAOproduct();
		SanPham sp = pro.getSanPhamByIdTT(maSanPham);
		
		theLoaiDAO tl= new theLoaiDAO();
		List<TheLoai> listC= tl.getAllTheLoai();
		
		request.setAttribute("listC", listC);
		request.setAttribute("thongTin", sp);
		request.getRequestDispatcher("/hienthi.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
