<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
<title>Personal Manager Tasks</title>
</head>
<body>
	<h2>Start Page</h2>
	<p>Welcome, ${loggedUser.login }</p>
	<a href="listTasks">Cliq here</a> to access the tasks list.
	<a href="logout">Sair do sistema</a>
</body>
</html>