package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAOproduct;
import model.SanPham;
import model.ShoppingCart;
import model.gioHangItem;

/**
 * Servlet implementation class ShoppingCartCL
 */
@WebServlet("/ShoppingCartCL")
public class ShoppingCartCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart shoppingCart;
		
		HttpSession session= request.getSession();
		shoppingCart=(ShoppingCart) session.getAttribute("cart");
		if( shoppingCart==null) {
			shoppingCart= new ShoppingCart();
			
			
		}
		session.setAttribute("cart", shoppingCart);
		
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
	    String action = request.getParameter("action");
	    switch (action) {
	        case "get":
	            response.sendRedirect("/bootstrap1/cart.jsp");
	            break;
	        case "delete":
	            // Gọi phương thức doDelete() khi action là "delete"
	            doDelete(request, response);
	            break;
	        case "put":
	            // Gọi phương thức doPut() khi action là "put"
	            doPut(request, response);
	            break;
	        case "post" :
	        	String maSanPham = request.getParameter("maSanPham");
	    	    DAOproduct pro = new DAOproduct();
	    	    SanPham sp = pro.getSanPhamByIdTT(maSanPham);
	    	    gioHangItem gioHangItem = new gioHangItem(sp, 1);
	    	    shoppingCart.add(gioHangItem);
	    	    session.setAttribute("cart", shoppingCart);
	    	    response.sendRedirect("home");
	    	    break;
	        default:
	           break;
	    }
	    
	    // Thêm sản phẩm vào giỏ hàng
	    
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doDelete(req, resp);
		HttpSession session = req.getSession();
	    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		String maSanPham= req.getParameter("maSanPham");
		shoppingCart.remove(maSanPham);
		session.setAttribute("cart",shoppingCart);
		 resp.sendRedirect("/bootstrap1/cart.jsp");
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
	    String maSanPham= req.getParameter("maSanPham");
		int soLuong= Integer.parseInt(req.getParameter("soLuong"));
		String error="";
		if(soLuong>0) {
			shoppingCart.update(maSanPham, soLuong);
		}else {
			error="Số lượng phải lớn hơn 0 sản phẩm!";
		}
		 req.setAttribute("error", error);
		session.setAttribute("cart",shoppingCart);
		req.getRequestDispatcher("ShoppingCartCL?action=get").forward(req, resp);
	}

}
