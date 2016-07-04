<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />

</head>
<body>
	<script type="text/javascript">
		function finishNow(id){
			$.post("finishTask", {'id':id}, function(answer) {
				$("#task_"+id).html(answer);
			});
		}
	
	</script>
	<a href="addTask">Add new task</a>
	<br> <br>
	<table>
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>Finished?</th>
			<th>Finished Date</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${tasks}" var="task">
			<tr id="task_${task.id}">
				<td>${task.id}</td>
				<td>${task.description}</td>
				<c:if test="${task.finished eq false}">
					<td>
						<a href="#" onClick="finishNow(${task.id})">
							Finish now!
						</a>
					</td>
				</c:if>
	
				<c:if test="${task.finished eq true}">
					<td>Finished</td>
				</c:if>
				<td>
					<fmt:formatDate
						value="${task.finishedDate.time}"
						pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<a href="removeTask?id=${task.id}">Remove</a>
				</td>
				<td>
					<a href="showTask?id=${task.id}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>