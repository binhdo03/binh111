<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Success</title>
<style>
    /* CSS để căn giữa và điều chỉnh khoảng cách giữa các dòng */
    .container {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: #ffcccc; /* Thay đổi màu nền ở đây */
    }

    .centered-text {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        font-size: 36px; /* Điều chỉnh kích thước chữ tùy ý */
        line-height: 1.5; /* Khoảng cách giữa các dòng */
        text-align: center; /* Căn giữa dòng */
        background-image: url('https://png.pngtree.com/background/20210714/original/pngtree-cartoon-giraffe-lion-forest-leaves-animal-background-picture-image_1236676.jpg');
    }
</style>
</head>
<body>

<!-- Đoạn chữ cần in giữa màn hình -->
<div class="container">
<div class="centered-text" >
   CHÚC MỪNG BẠN ĐÃ ĐĂNG KÍ THÀNH CÔNG!<br>
    <a href="login.jsp">Đăng Nhập Ngay</a> 
</div>
</div>
</body>
</html>
