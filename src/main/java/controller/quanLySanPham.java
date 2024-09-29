package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class quanLySanPham
 */
@WebServlet("/quanLySanPham")
public class quanLySanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanLySanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		// dat data tu dao
		//day len jsp
		String url="/AdminProduct.jsp";
		DAOproduct pro= new DAOproduct();
		theLoaiDAO tl= new theLoaiDAO();
		List<SanPham> list = pro.getAllSanPham();
		List<TheLoai> listC = tl.getAllTheLoai();
		request.setAttribute("listP", list);
		request.setAttribute("listC", listC);
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
