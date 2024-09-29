<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Danh sách sản phẩm</h2>
    <c:forEach var="sanPham" items="${sanPhamList}">
        <div>
            <img src="${sanPham.hinhAnh}" alt="${sanPham.tenSanPham}" width="100">
            <p>${sanPham.tenSanPham}</p>
            <p>${sanPham.giaBan} VND</p>
            <form action="addToCart" method="post">
                <input type="hidden" name="maSanPham" value="${sanPham.maSanPham}">
                <input type="number" name="soLuong" value="1" min="1">
                <button type="submit">Thêm vào giỏ</button>
            </form>
        </div>
    </c:forEach>
    <a href="gioHang.jsp">Xem giỏ hàng</a>
</body>
</html>