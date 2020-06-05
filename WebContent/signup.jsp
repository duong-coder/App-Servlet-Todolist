<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	<form action="./dangkytaikhoan" method="post"> 
		<label for="user-name">Ten dang nhap</label> <br>
		<input type="text" id="user-name" name="username"><br>
		<label for="pass">Mat khau</label> <br>
		<input type="password" id="pass" name="pass"><br>
		<label for="fullname">Ho va ten</label> <br>
		<input type="text" id="fullname" name="fullname"><br>
		<label>Gioi tinh</label>
		<input type="radio" id="male" name="gender" value="true">
		<label for="male">Nam</label>
		<input type="radio" id="female" name="gender" value="false">
		<label for="female">Nu</label> <br>
		<label for="sdt">SDT</label> <br>
		<input type="text" id="sdt" name="sdt"><br>
		<label for="email">Email</label> <br>
		<input type="email" id="email" name="email"><br>
		
		<input type="submit" value="Dang ky">
		<a href="./getdangnhap"><input type="button" value="Quay lai"></a>
	</form> 
</body>
</html>