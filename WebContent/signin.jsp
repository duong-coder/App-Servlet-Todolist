<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn</title>
</head>
<body>
	<form action="./dangnhap" method="post">
		<label for="user-name">Ten dang nhap</label> <br>
		<input type="text" id="user-name" name="username"><br>
		<label for="pass">Mat khau</label> <br>
		<input type="password" id="pass" name="pass"><br>
		
		<input type="submit" value="Dang nhap">
		<a href="./getdangky"><p>Hoac dang ky tai day!</p></a>
	</form>
</body>
</html>