<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Personal Tasks Manager</title>
</head>
<body>
	<div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">PersonalTasksManager.com</h3>
      </div>

      <div class="jumbotron">
        <h1>A powerful tasks manager open source!</h1>
        <p class="lead">Personal Tasks Manager is open source project of a powerful tasks manager. If you know Java, 
        	Spring MVC, MySQL, Hibernate, Bootstrap, ... Let's do together! </p>
        <p><a class="btn btn-lg btn-success" href="https://github.com/daniellfeijo/personaltasksmanager" role="button">Let's do together! See the code!</a></p>
      </div>

      <div class="row marketing">
        <div class="col-xs-12 col-sm-6 col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="col-xs-12 col-sm-6 col-lg-6">
         	<div class="container col-xs-12 col-sm-12 col-lg-12">
	        	<h2>Sign In</h2>
	        	<p>Access Personal Tasks Manager</p>
				<form action="makeLogin" method="post">
				  <div class="form-group">
				    <label for="inputEmail3" class="control-label">Email</label>
				    <div>
				      <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="control-label">Password</label>
				    <div>
				      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2">
				      <div class="checkbox">
				        <label>
				          <input type="checkbox"> Remember me
				        </label>
				      </div>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2">
				      <button type="submit" class="btn btn-default">Sign in</button>
				    </div>
				  </div>
				</form>
			</div>
        </div>
      </div>
		
	<div class="row">
		<footer class="footer col-xs-12 col-sm-12 col-lg-12">
	 		<p>&copy; 2015 Company, Inc.</p>
		</footer>
	</div>
    </div> <!-- /container -->
	

<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>	
</body>
</html>