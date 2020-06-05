<%@page import="com.database.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang chu</title>
<link rel="stylesheet" href="navigator.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0px;
}

.navigator {
	margin: 0px;
}

.nav {
	margin: 0px;
	padding: 10px;
	display: flex;
	justify-content: flex-end;
	align-items: center;
	background-color: aquamarine;
	/* overflow: hidden; */
}

.nav>h3 {
	margin-left: 10px;
	/* background-color: violet; */
}

.nav>div.menu {
	width: fit-content;
	display: block;
	position: relative;
}

.nav>div.menu>img {
	display: block;
	margin-left: 30px;
	margin-right: 20px;
	padding: 5px;
	background-color: #b1b493;
}

.nav>div.menu:hover>.menu_select {
	display: block;
}

.nav #logo-user {
	background-color: #DDD;
	width: fit-content;
	border-radius: 100%;
}

.nav #logo-user>img {
	width: 60px;
	height: 60px;
	border-radius: 100%;
}

.menu_select {
	display: none;
	margin: 0px;
	background-color: wheat;
	width: fit-content;
	position: absolute;
	top: 100%;
	right: 0px;
}

.menu_select ul {
	margin: 0px;
	padding: 10px;
	list-style: none;
	background-color: #DDD;
}

.menu_select li {
	margin: 0px;
	margin-bottom: 5px;
	width: 150px;
	padding: 10px;
	background-color: rgb(77, 76, 76);
}

.menu_select a {
	display: block;
	text-decoration: none;
	color: white;
}


</style>
</head>
<body>
	<div class="navigator">
		<nav class="nav">
			<div id="logo-user">
				<img src="https://img.icons8.com/carbon-copy/100/000000/user.png" />
			</div>
			<h3>
				Xin chào,
				<%
				try {
					User user2 = (User) getServletContext().getAttribute("name");
					out.print(user2.getFullName());
				} catch (Exception e) {
					out.print("Khach");
				}
			%>
			</h3>
			<div class="menu">
				<img src="https://img.icons8.com/android/24/000000/menu.png" />
				<div class="menu_select">
					<ul>
						<li><a href="./getdangnhap">Dang nhap</a></li>
						<li><a href="">Xem thong tin</a></li>
						<li><a href="./getnotes">Xem cac ghi chu</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<article>aaa</article>

</body>
</html>