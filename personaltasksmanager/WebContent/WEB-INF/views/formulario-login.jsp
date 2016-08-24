<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <li role="presentation" class="active"><a href="#"><fmt:message key="menu.home"/></a></li>
            <li role="presentation"><a href="#"><fmt:message key="menu.about"/></a></li>
            <li role="presentation"><a href="#"><fmt:message key="menu.contact"/></a></li>
            <li class="nav-item dropdown">
               <a href="#" class="nav-link dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-flag"></i> <fmt:message key="menu.language"/></a>
               <div class="dropdown-menu dropdown-default" aria-labelledby="dropdownMenu1" data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                   <ul class="nav nav-pills">
	                   <li><a class="dropdown-item" href="changeLangue?langue=en"><fmt:message key="menu.english"/></a></li>
	                   <li><a class="dropdown-item" href="changeLangue?langue=pt"><fmt:message key="menu.portuguese"/></a></li>
               		</ul>
               </div>
           </li>
                </ul>
          
        </nav>
        <h3 class="text-muted">PersonalTasksManager.com</h3>
      </div>

      <div class="jumbotron">
        <h1><fmt:message key="mainjumbotron.title"/></h1>
        <p class="lead"><fmt:message key="mainjumbotron.mainmessage"/></p>
        <p><a class="btn btn-lg btn-success" href="https://github.com/daniellfeijo/personaltasksmanager" role="button"><fmt:message key="mainjumbotron.btn"/></a></p>
      </div>

      <div class="row marketing">
        <div class="panel-group col-xs-12 col-sm-4 col-lg-4" id="panels-information1">
                
      		<div class="panel panel-default">
        		<div class="panel-heading">
          			<h3 class="panel-title" data-toggle="collapse"
          				data-target="#information1-1" data-parent="#panels-information1">User profiles</h3>
        		</div>
        	<div id="information1-1" class="collapse in">
          		<div class="panel-body">
            		<p><strong>root</strong> - Users  with "root" profile can add, enable and disable any user.</p>
            		<p><strong>user</strong> - the general profile for all users.</p>
          		</div>
        	</div>
      	</div>
      	
      	
      	<div class="panel panel-default">
        	<div class="panel-heading">
          		<h3 class="panel-title" data-toggle="collapse"
          			data-target="#information1-2" data-parent="#panels-information1">Priority of Tasks</h3>
        	</div>
        	<div id="information1-2" class="collapse">
          		<div class="panel-body">
            		<p>Priority of Tasks can be <strong>High</strong>, <strong>Moderate</strong> and <strong>Low</strong></p>
          		</div>
        	</div>
      	</div>
      	
      	
      	
                
          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
        
        
	<div class="panel-group col-xs-12 col-sm-4 col-lg-4" id="panels-information2">               
      	<div class="panel panel-default">
        		<div class="panel-heading">
          			<h3 class="panel-title" data-toggle="collapse"
          				data-target="#information2-1" data-parent="#panels-information2">Work Groups</h3>
        		</div>
        	<div id="information2-1" class="collapse">
          		<div class="panel-body">
            		<p>The work groups has a owner and a members list.</p>
          		</div>
        	</div>
      	</div>
      	
      	
      	<div class="panel panel-default">
        	<div class="panel-heading">
          		<h3 class="panel-title" data-toggle="collapse"
          			data-target="#information2-2" data-parent="#panels-information2">Priority of Tasks</h3>
        	</div>
        	<div id="information2-2" class="collapse">
          		<div class="panel-body">
            		<p>Priority of Tasks can be <strong>High</strong>, <strong>Moderate</strong> and <strong>Low</strong></p>
          		</div>
        	</div>
      	</div>
      	                
        <h4>Subheading</h4>
        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

        <h4>Subheading</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
	</div>
        
        
        

        <div class="col-xs-12 col-sm-4 col-lg-4">
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