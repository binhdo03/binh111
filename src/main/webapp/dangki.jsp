<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.red {
	color: red;
}
</style>
<style type="text/css">
	.white{
	color: white;
	}
</style>
</head>
<body>
	<%
		String error =(request.getAttribute("arror")+"").equals("null")?"":(request.getAttribute("arror")+"");
		
	
		String tenDangNhap =request.getAttribute("tenDangNhap")+"";
		tenDangNhap=(tenDangNhap.equals("null"))?"":tenDangNhap;
		
		String matKhau=request.getAttribute("matKhau")+"";
		matKhau=(matKhau.equals("null"))?"":matKhau;
		
		String matKhauNhapLai=request.getAttribute("matKhauNhapLai")+"";
		matKhauNhapLai=(matKhauNhapLai.equals("null"))?"":matKhauNhapLai;
		
		String hoVaTen=request.getAttribute("hoVaTen")+"";
		hoVaTen=(hoVaTen.equals("null"))?"":hoVaTen;
		
		String gioiTinh=request.getAttribute("gioiTinh")+"";
		gioiTinh=(gioiTinh.equals("null"))?"":gioiTinh;
		
		String diaChi=request.getAttribute("diaChi")+"";
		diaChi=(diaChi.equals("null"))?"":diaChi;
		
		String dienThoai=request.getAttribute("dienThoai")+"";
		dienThoai=(dienThoai.equals("null"))?"":dienThoai;
		
		String ngaySinh=request.getAttribute("ngaySinh")+"";
		ngaySinh=(ngaySinh.equals("null"))?"":ngaySinh;
		
		String email=request.getAttribute("email")+"";
		email=(email.equals("null"))?"":email;
		
		String dongYDieuKhoan=request.getAttribute("dongYDieuKhoan")+"";
		dongYDieuKhoan=(dongYDieuKhoan.equals("null"))?"":dongYDieuKhoan;
	%>
	<div class="container" style="background-image: url('https://assets.samsungvn.com/wp-content/uploads/2021/08/02133757/Mo-hop-Galaxy-Watch4-Classic-samsungvn.com-36.jpg')">
		<div class="text-center">
			<h1><span class="white">ĐĂNG KÝ TÀI KHOẢN</span></h1>
		</div>
		
		
		<form class="form" action="dang-ky" method="post">
			<div class="row">
				<div class="col-sm-6">
					<p class="text-danger">${error}</p>
					<h3><span class="white">Tài Khoản</span></h3>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label"><span class="white">Tên đăng nhập</span><span
							class="red">*</span></label> <input type="text" class="form-control"
							id="tenDangNhap" name="tenDangNhap" required="required" value="">
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label"><span class="white">Mật Khẩu</span><span
							class="red">*</span></label> <input type="password" class="form-control"
							id="matKhau" name="matKhau" required="required" onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="=i" class="form-label" ><span class="white">Nhập lại mật khẩu</span>
							<span class="red">*</span> <span id="msg" class="red" ></span>
						</label> <input type="password" class="form-control" id="matKhauNhapLai"
							name="matKhauNhapLai" required="required" onkeyup="kiemTraMatKhau()">
					</div>
					<hr />
					<h3><span class="white">Thông tin khách hàng</span></h3>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label"><span class="white">Họ và tên</span></label> <input
							type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen%>">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label"><span class="white">Giới Tính</span></label> <select
							class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh=="Nam")?"selected='selected'":"" %> ><span class="white">Nam</span></option>
							<option value="Nữ" <%=(gioiTinh=="Nữ")?"selected='selected'":"" %>> <span class="white">Nữ</span></option>
							<option value="Khác" <%=(gioiTinh=="Khác")?"selected='selected'":"" %>> <span class="white">Khác</span></option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label"><span class="white">Ngày sinh</span></label> <input
							type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
					</div>
				</div>
				<div class="col-sm-6">
					<h3><span class="white">Địa Chỉ</span></h3>
					<div class="mb-3">
						<label for="diaChi" class="form-label"><span class="white">Địa chỉ khách hàng</span>
							</label> <input type="text" class="form-control"
							id="diaChi" name="diaChi" value="<%=diaChi%>">
					</div>
					
					<div class="mb-3">
						<label for="dienThoai" class="form-label"><span class="white">Điện Thoại</span></label> <input
							type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label"><span class="white">Emai</span></label> <input
							type="email" class="form-control" id="email" name="email"  value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label"><span class="red"><a> Đồng ý với điều khoản của công ty </a></span>
							<span id="red">*</span>
						</label> <input type="checkbox" class="form-check-input"
							id="dongYDieuKhoan" name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" style="visibility: hidden;" />
				</div>
			</div>
		</form>
	</div>
</body>

<script>
	function kiemTraMatKhau(){
		matKhau = document.getElementById("matKhau").value;
		matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
		if(matKhau!=matKhauNhapLai){
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		}else{
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	
	function xuLyChonDongY(){
		dongYDeuKhoan = document.getElementById("dongYDieuKhoan");
		if(dongYDeuKhoan.checked==true){
			document.getElementById("submit").style.visibility="visible";
		} else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
</script>

</html>