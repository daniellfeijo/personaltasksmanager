<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dlftasks</title>
</head>
<body>
	<h3>Add Task</h3>
	<form:errors path="task.description" cssStyle="color:red" /><br>
	<form action="addTask" method="post">
		Description: <br>
		<textarea name="description" rows="5" cols="100"></textarea><br>
		<input type="submit" value="Add">
	</form>
</body>
</html>