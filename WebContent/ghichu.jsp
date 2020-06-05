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
<title>Todolist</title>
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
	/* height: fit-content; */
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

	<div id="login-background" class="container">
		<div class="row d-flex justify-content-center text-center">
			<div class="col-md-10">
				<h4 class="display-4 font-weight-bold white-text pt-5 mb-2">Todolist</h4>

				<hr class="hr-light">
			</div>
		</div>
		<table class="table table-primary table-hover table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Date</th>
					<th scope="col">Content</th>
					<th scope="col">Button</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Test</td>
					<td>6/4/2020</td>
					<td>Demo table</td>
					<td><a class="btn btn-info my-2 my-sm-0" href="#"
						role="button">Edit</a> <a class="btn btn-warning my-2 my-sm-0"
						href="#" role="button">Delete</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>