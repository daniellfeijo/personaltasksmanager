<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html">
<html>
<head>
		<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
</head>
<body>
	<h3>Edit task - ${task.id}</h3>

	<form action="editTask" method="post">
		<input type="hidden" name="id" value="${task.id}" />
		Descrição:<br>
		<textarea name="description"
			cols="100" rows="5">${task.description}</textarea>
		<br>
		Finished? <input type="checkbox" name="finished"
			value="true" ${task.finished? 'checked' : '' }/> <br />

		Finished Date: <br />
		<input type="text" name="FinishedDate" value="<fmt:formatDate
			value="${task.finishedDate.time}" pattern="yyyy-MM-dd" />"/>
		<br>

		<input type="submit" value="Alterar"/>
	</form>
</body>
</html>
