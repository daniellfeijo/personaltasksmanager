<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Personal Tasks Manager</title>
</head>
<body>
	<div class="container">
		<form action="makeLogin" method="post" class="form-inline">
  			<div class="form-group">
				<label for="exampleInputName2">Login</label>
				<input type="text" name="login" class="form-control" id="exampleInputName2" placeholder="Login"/>
			</div>
  			<div class="form-group">
				<label for="exampleInputEmail2">Password:</label>
				 <input type="password" name="password" class="form-control" id="exampleInputEmail2"/>
			</div>
			<button type="submit" value="Login" class="btn btn-default">Login</button>
		</form>
	</div>

<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>	
</body>
</html>