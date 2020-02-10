<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delectable Doughnuts</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
body {
	background-image:
		url('image/dnut_back.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="logout.chan"> Delectable D<img
			src="image/smalld.png"
			height="45" width="45">ughnuts
		</a>
		<a class="navbar-brand"  href="logout.chan">${requestScope["logout"]}</a>
	</nav>
<!-- template -->







	<br>
	<br>
	<br>
		<div class="card text-white bg-dark mb-3 mx-auto align-middle rounded-circle" style="width: 490px; height: 490px; ">
			<div class="card-body">
				<div style="color: white; margin: 30px;">

					<h1 style="text-align: center; margin-top: 50px; margin-bottom: 25px;">
						<br>
						${requestScope["tital"]}
					</h1>
					<br>
					<p style="text-align: center;">
						${requestScope["cont"]}
					</p>
					<br>
					<form method="post" action=${requestScope["bLink"]}>
						<div class="container">
							<div class="row justify-content-md-center">
								<div class="col-3"></div>
								<div class="col-6">
									<button type="submit" value="" class="btn btn-lg btn-block"
										style="background-color: rgb(231, 120, 213);">
										<b>${requestScope["bText"]}</b>
									</button>
								</div>
								<div class="col-3"></div>
							</div>
						</div>
					</form>
				</div>
				<br>
				<br>
			</div>
		</div>






<!-- template -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>