<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5" style="background-image: url('https://img.lovepik.com/background/20211022/medium/lovepik-pink-background-full-screen-poster-banner-image_605811391.jpg');">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="text-center">Chỉnh sửa sản phẩm</h2>
                <form action="update" method="post">
                    <div class="form-group">
                        <label for="maSanPham">Mã sản phẩm:</label>
                        <input type="text" class="form-control" id="maSanPham" name="maSanPham" value="${thongTin.maSanPham }" readonly="readonly" required>
                    </div>
                    <div class="form-group">
                        <label for="tenSanPham">Tên sản phẩm:</label>
                        <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="${thongTin.tenSanPham }" required>
                    </div>
                    <div class="form-group">
                        <label for="hinhAnh">Hình ảnh:</label>
                        <input type="text" class="form-control" id="hinhAnh" name="hinhAnh" value="${thongTin.hinhAnh }" required>
                    </div>
                    <div class="form-group">
                        <label for="giaBan">Giá bán:</label>
                        <input type="text" class="form-control" id="giaBan" name="giaBan" value="${thongTin.giaBan } $" required>
                    </div>
                    <div class="form-group">
                        <label for="xuatXu">Xuất xứ:</label>
                        <input type="text" class="form-control" id="xuatXu" name="xuatXu" value="${thongTin.xuatXu }"  required>
                    </div>
                    <div class="form-group">
                        <label for="moTa">Mô tả:</label>
                        <textarea class="form-control" id="moTa" name="moTa" rows="3" required>${thongTin.mota} </textarea>
                    </div>
                   
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
