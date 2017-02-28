<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/external/bootstrap-3.3.6-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/external/bootstrap-3.3.6-dist/css/dashboard.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <script src="resources/task/list/js/task-list.js" type="text/javascript"></script>
    <script src="resources/jQuery-v1.12.2/jquery.js"></script>
    <script src="resources/external/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	<title>Personal Tasks Manager</title>
</head>
<body>
    <nav class="navbar navbar-default container">
		<c:import url="../../menu/menu_header.jsp"/>
    </nav>

    <div class="container-fluid container">
      <div class="row">
        <div class="col-sm-12 col-md-12 main">
          <h1 class="page-header">All Tasks</h1>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
					<th>Id</th>
					<th>Open Date</th>
					<th>From</th>
					<th>For</th>
					<th>Description</th>
					<th>Finished?</th>
					<th>Finished Date</th>
					<th></th>
					<th></th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${tasks}" var="task">
					<tr id="task_${task.id}">
						<td>${task.id}</td>
						<td><fmt:formatDate
								value="${task.openDate.time}"
									pattern="yyyy-MM-dd"/></td>
						<td>${task.userOpening.email}</td>
						<td>${task.userDestination.email}</td>
						<td>${task.description}</td>
						<c:if test="${task.finished eq false}">
							<td id="task_finish_${task.id}">
								<a href="#" onClick="finishNow(${task.id})">
									Finish now!
								</a>
							</td>
						</c:if>

						<c:if test="${task.finished eq true}">
							<td>Finished</td>
						</c:if>
						<td id="task_finishedDate_${task.id}">
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
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
