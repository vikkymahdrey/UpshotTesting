<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"
	http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
 <script src="js/jquery.min.js"></script>
<title>Login</title>
</head>
<body>

	<div class="container">
		<br> <br>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<center>
						<strong><h1>Upshot Login</h1></strong>
					</center>
				</div>
				<!--<div class="panel-body"><center><strong</strong></center></div>-->
			</div>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Please Login</h4>
					</div>
					<div class="panel-body">
						<form method="POST" action="Login" >

							<div class="form-group">
								<label for="text">Username :</label> <input type="text"
									class="form-control" id="username" placeholder="Enter username"
									name="username" required="">
							</div>
							<div class="form-group">
								<label for="pwd">Password :</label> <input type="password"
									class="form-control" id="password" placeholder="Enter password"
									name="password" required="">
							</div>

							<input type="submit" class="btn btn-primary" name="submit"
								value="Login" /> <br>


						</form>
						<div>
							<u><h4>
									<a href="forgotPage.jsp">Forgot password</a>
								</h4></u>
						</div>
						<div>
							<u><h4>
									<a href="addUser.jsp">New user?</a>
								</h4></u>
						</div>

					</div>
				</div>
				<div class="col-xs-4"></div>
			</div>
		</div>
	</div>


</body>
</html>