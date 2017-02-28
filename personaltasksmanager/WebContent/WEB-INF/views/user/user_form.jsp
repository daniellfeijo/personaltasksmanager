<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/external/bootstrap-3.3.6-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/external/bootstrap-3.3.6-dist/css/dashboard.css">
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
							<input type="email" value="${user.email}" name="email" 
								class="form-control" id="inputEmail" placeholder="E-mail">
							<span class="label label-danger">${emailException}</span>
							<span class="label label-danger">${userProfileException}</span>
							<span class="label label-danger">${noSuchAlgorithmException}</span>
						</div>
			    		<label for="selectProfile" class="col-sm-2 control-label">Profile</label>
		    			<div class="col-sm-2"><!--
		        			--><select id="selectProfile" class="form-control" name="profile">
							<c:if test="${user.profile != null}">
								<option selected value="${user.profile}">${user.profile }</option>
								<c:if test="${user.profile == 'root'}">
					  				<option value="user">user</option>
								</c:if>
								<c:if test="${user.profile == 'user'}">
								  <option value="root">root</option>
								</c:if>
							</c:if>		        			
							<c:if test="${user.profile == null}">
							  <option value="root">root</option>
							  <option value="user" selected>user</option>
							</c:if>		        			
		        			</select>
		        			<span class="label label-danger">${userProfileException}</span>
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
<script src="resources/jQuery-v1.12.2/jquery.js"></script>
<script src="resources/external/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>		
</body>
</html>