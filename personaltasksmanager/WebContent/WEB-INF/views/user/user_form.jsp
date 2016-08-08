<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/dashboard.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Personal Tasks Manager</title>
</head>
<body>
    <nav class="navbar navbar-default container">
		<c:import url="../menu/menu_header.jsp"/>
    </nav>
    
	<div class="container-fluid container">
		<div class="row">            
			<div class="col-sm-12 col-md-12 main">
				<h1 class="page-header">Add User</h1>
				<form action="addUser" method="post" class="form-horizontal">
			  		<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">E-mail</label>
						<div class="col-sm-5">									
							<input type="email" name="email" class="form-control" id="inputEmail" placeholder="E-mail">
							<span class="label label-danger">${emailException}</span>
						</div>
			    		<label for="selectProfile" class="col-sm-2 control-label">Profile</label>
		    			<div class="col-sm-2"><!--
		        			--><select id="selectProfile" class="form-control" name="profile">
		          			<option value="root">root</option>
		          			<option value="user" selected>user</option>
		        			</select>
	    				</div>
			  			    
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Save</button>
			    </div>
			  </div>
			</form>
		</div>
      </div>
    </div>
<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>		
</body>
</html>