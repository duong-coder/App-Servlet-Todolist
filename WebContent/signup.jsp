<%@page import="com.todolist.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" href="./css/navigator.css"> -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Sign up</title>
<style>
html, body, header, #login-background {
	height: 100%;
}

.login {
	padding-top: 5%;
}

.login-card {
	width: 400px;
}

#login-background {
	height: fit-content;
	padding: 20px;
	background-image:
		url("https://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img(20).jpg");
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>

<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light scrolling-navbar">
		<div class="container">
			<a class="navbar-brand" href="#"><img
				src="https://img.icons8.com/carbon-copy/100/000000/user.png"
				alt="..." class="img-thumbnail" style="width: 50px; height: 50px;"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse  " id="navbarNav">
				<ul class="navbar-nav mr-auto smooth-scroll">
					<li class="nav-item active"><a class="nav-link text-info"
						href="#">Xin chào, 
							<%
								User user = (User) getServletContext().getAttribute("user");
								if(user == null){
									out.print("Khách.");
								} else{
									out.print(user.getFullname());
								}
							%>
						</a></li>
					<li class="nav-item active "><a class="nav-link " href="./home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active "><a class="nav-link "
						href="./todolists">Todo List <span class="sr-only">(current)</span></a>
					</li>
				</ul>

			</div>
			<form class="form-inline ml-auto">
				<a class="btn btn-primary  mr-sm-2 " href="./signin"
					role="button">Sign in</a> <a class="btn btn-primary my-2 my-sm-0"
					href="./signup" role="button">Sign up</a>
			</form>
		</div>
	</nav>

	<div id="login-background" class="container login">
		<div class="d-flex justify-content-center">
			<!--Form-->
			
			<div class="card wow fadeInRight" data-wow-delay="0.3s">
				<div class="card-body login-card">
					<!--Header-->
					<div class="text-center">
						<img src="https://img.icons8.com/carbon-copy/100/000000/user.png"
							alt="kkkkkk" class="img-thumbnail"
							style="width: 50px; height: 50px;">
						<h3 class="white-text">
							<i class="fas fa-user white-text"></i>Sign up
						</h3>
						<hr class="hr-light">
					</div>
					<!--Body-->
					<form action="./signup" method="post">
						<div class="md-form">
							<label for="username">Username</label> 
							<input type="text" id="username" name="username" class="white-text form-control my-2">
						</div>
						<div class="md-form">
							<label for="password">Password</label>
							 <input type="password" id="password" name="password" class="white-text form-control my-2">
						</div>
						<div class="md-form">
							<label for="yourName">Your name</label> 
							<input type="text" id="yourName" name="fullname" class="white-text form-control my-2">
						</div>
						<div class="md-form">
							<label>Gender</label>
							<div class="form-check  ml-3">
								<input class="form-check-input" type="radio" name="gender" id="male" value="male" >
								 <label class="form-check-label" for="male"> Male </label>
							</div>
							<div class="form-check ml-3">
								<input class="form-check-input" type="radio" name="gender"
									id="female" value="female" checked> 
									<label class="form-check-label" for="female"> Female </label>
							</div>
						</div>
						<div class="md-form">
							<label for="email">Email address</label> 
							<input type="text" id="email" name="email" class="white-text form-control my-2">
						</div>
						<div class="md-form">
							<label for="phone">Phone</label> 
							<input type="text" id="phone" name="phone" class="white-text form-control my-2">
						</div>
						<div class="text-center mt-4">
							<button class="btn btn-indigo btn btn-success w-100" type="submit">Sign up</button>
						</div>
					</form>
				</div>
			</div>
			
			<!--/.Form-->
		</div>
	</div>

</body>

</html>