<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="t" class="database.DAOproduct" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang Chủ</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Thể Loại</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Khuyến Mãi</li>
                </ol>
            </nav>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-warning text-primary text-uppercase">
                    <i class="fa fa-list"></i> Thể Loại
                    <ul class="list-group category_block text-sm">
                        <c:forEach items="${listC}" var="theLoai">
                            <li class="list-group-item text-white ${tag==theLoai.maTheLoai ? 'active' : ''}">
                                <a href="TheLoai?maTheLoai=${theLoai.maTheLoai}">${theLoai.tenTheLoai}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-sm-9">
            <div class="row">
                <c:forEach items="${listP}" var="sanPham">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${sanPham.hinhAnh}" alt="Hình ảnh sản phẩm">
                            <div class="card-body">
                                <h4 class="card-title show_txt">
                                    <a href="thongTin?maSanPham=${sanPham.maSanPham}" title="Xem sản phẩm">${sanPham.tenSanPham}</a>
                                </h4>
                                <p class="card-text show_txt">Xuất xứ: ${sanPham.xuatXu}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${sanPham.giaBan}$</p>
                                    </div>
                                    <div class="col">
                                        <a href="ShoppingCartCL?action=post&maSanPham=${sanPham.maSanPham}" class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
