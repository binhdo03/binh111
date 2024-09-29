<%@page import="java.text.NumberFormat"%>
<%@page import="model.gioHangItem"%>
<%@page import="java.util.List"%>
<%@page import="model.ShoppingCart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%
ShoppingCart shoppingCart =(ShoppingCart)session.getAttribute("cart");
if(shoppingCart==null){
	shoppingCart= new ShoppingCart();
}
List<gioHangItem> listIteams= shoppingCart.getGioHangItemList();
NumberFormat numberFormat=NumberFormat.getCurrencyInstance();

String error= request.getAttribute("error")==null?"":request.getAttribute("error")+"";
%>
<body>
    <jsp:include page="menu.jsp"></jsp:include>
    <div class="shopping-cart">
        <div class="px-4 px-lg-0">
            <div class="pb-5">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                            <!-- Shopping cart table -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Đơn Giá</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Số Lượng</div>
                                            </th>
                                            
                                             <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Tổng Tiền</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Xóa</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Sửa Số Lượng</div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% 
                                    int cnt=0;
                                    for(gioHangItem gioHangItem:listIteams){
                                    	
                                    	
                                    %>
                                    <tr>
                                        <th scope="row">
                                            <div class="p-2">
                                                <img src="<%=gioHangItem.getSanPham().getHinhAnh() %>" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                <div class="ml-3 d-inline-block align-middle">
                                                    <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"><%=gioHangItem.getSanPham().getTenSanPham() %></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                </div>
                                            </div>
                                        </th>
                                        <td class="align-middle"><strong><%=gioHangItem.getSanPham().getGiaBan()%></strong></td>
                                        
                                        <td class="align-middle">
                                            <strong><%=gioHangItem.getSoLuong() %></strong>
                                        </td>
                                        
                                        <td class="align-middle"><strong><%=numberFormat.format(gioHangItem.getTongTien())%></strong></td>                                    
                                        <td class="align-middle">
                                        <form action="ShoppingCartCL">
                                        <input type="hidden" name ="action" value="delete">
                                        <input type="hidden" name ="maSanPham" value="<%=gioHangItem.getSanPham().getMaSanPham()  %>">
                                                <button type="submit" class="btn btn-danger">Delete</button>
                                          </form>
                                        </td>
                                         <td class="align-middle">
                                         	
                                        	<form action="ShoppingCartCL">
                                        		<input type="number" name="soLuong" value="<%=gioHangItem.getSoLuong()%>">
                                        		<input type="hidden" name="action" value="put">
                                        		<input type="hidden" name="maSanPham" value="<%=gioHangItem.getSanPham().getMaSanPham()%>">
                                        		<button type="submit" class="btn btn-danger btn-sm"> cập nhập</button>
                                        	
                                        	</form>
                                        	
                                        </td>
                                      
                                    </tr> 
                                   <%} %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- End -->
                        </div>
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
                        <div class="p-4">
                            <div class="input-group mb-4 border rounded-pill p-2">
                                <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                                <div class="input-group-append border-0">
                                    <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong><%=shoppingCart.getTongGioHang() %> $</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong><%=shoppingCart.getVat() %></strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                    <h5 class="font-weight-bold"><%=shoppingCart.getTongThanhToan() %></h5>
                                </li>
                    		 </ul>
                    		 <c:if test="${sessionScope.acc == null}">
                            <a href="login.jsp" class="btn btn-dark rounded-pill py-2 btn-block">Bạn Cần đăng nhập để mua hàng!</a>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">
                            <a href="donHang.jsp" class="btn btn-dark rounded-pill py-2 btn-block">Mua Hàng</a>
                            </c:if>
                           <a href="home" class="btn btn-dark rounded-pill py-2 btn-block">Tiếp tục mua sắm</a>
                            <p class="text-danger"><%=error %></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>

