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
<title>Sign in</title>
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
						href="#">Xin chào, Khách</a></li>
					<li class="nav-item active "><a class="nav-link " href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active "><a class="nav-link "
						href="./getnotes">Todo List <span class="sr-only">(current)</span></a>
					</li>
				</ul>

			</div>
			<form class="form-inline ml-auto">
				<a class="btn btn-primary  mr-sm-2 " href="./getdangnhap"
					role="button">Sign in</a> <a class="btn btn-primary my-2 my-sm-0"
					href="#" role="button">Sign up</a>
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
							<i class="fas fa-user white-text"></i>Sign in
						</h3>
						<hr class="hr-light">
					</div>
					<!--Body-->
					<div class="md-form">
						<i class="fas fa-user prefix white-text active"></i> <input
							type="text" id="form3" class="white-text form-control my-2"
							placeholder="Your name">
					</div>
					<div class="md-form">
						<i class="fas fa-lock prefix white-text active"></i> <input
							type="password" id="form4" class="white-text form-control my-2"
							placeholder="Your password">
					</div>
					<div class="text-center mt-4">
						<a href=""><button
								class="btn btn-indigo btn btn-success w-100">Sign in</button></a>
					</div>
				</div>
			</div>
			<!--/.Form-->
		</div>
	</div>

</body>

</html>