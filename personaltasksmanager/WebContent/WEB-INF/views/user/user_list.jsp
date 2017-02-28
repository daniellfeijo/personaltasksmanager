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
          <h1 class="page-header">All Users</h1>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
					<th>Id</th>
					<th>Enabled</th>
					<th>Email</th>
					<th>Profile</th>
					<th>Disable/Enable</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${users}" var="user">
					<tr id="user_${user.id}">
						<td>${user.id}</td>
						<td>${user.enabled}</td>
						<td>${user.email}</td>
						<td>${user.profile}</td>
						<c:if test="${user.enabled eq true}">
							<td>
								<a href="disableUserRoot?id=${user.id}">Disable</a>
							</td>
						</c:if>

						<c:if test="${user.enabled eq false}">
							<td>
								<a href="enableUserRoot?id=${user.id}">Enable</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
<script src="resources/jQuery-v1.12.2/jquery.js"></script>
<script src="resources/external/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</body>
</html>
