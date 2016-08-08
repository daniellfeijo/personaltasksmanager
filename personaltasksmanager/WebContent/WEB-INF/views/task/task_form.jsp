<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
          <h1 class="page-header">Add Task</h1>
					<form action="addTask" method="post" class="form-horizontal">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Description</label>
			    <div class="col-sm-10">
					<form:errors path="task.description"/>
			      <textarea rows="5" cols="100" name="description" class="form-control" id="inputEmail3" placeholder="Email"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Priority</label>
			    <div class="col-sm-2"><!--
			        --><select class="form-control" >
			          <option>High</option>
			          <option selected>Moderate</option>
			          <option>Low</option>
			        </select>
			    </div>
			  
			    <label for="inputPassword3" class="col-sm-2 control-label">Group</label>
			    <div class="col-sm-2">
			      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			    <label for="inputPassword3" class="col-sm-2 control-label">Projeto</label>
			    <div class="col-sm-2">
			      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			    
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-3 control-label">Projeto</label>
			    <div class="col-sm-3">
			      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>

			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Send a email for responsible for the task
			        </label>
			      </div>
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