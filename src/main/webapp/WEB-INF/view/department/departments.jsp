<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Departments</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Employees app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/employees/" />" title="Employees">Employees</a></li>
					<li><a href="<s:url value="/employees/new" />"
						title="New employee">New employee</a></li>
					<li><a href="<s:url value="/departments/" />"
						title="Departments">See departments</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container">

		<div class="jumbotron">
			<h1>Departments list</h1>
			<p>These are the departments currently in the system.</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${departments}" var="department">
					<tr>
						<td>${department.getId()}</td>
						<td>${department.getName()}</td>
						<td>${department.getDescription()}</td>
						<td><a class="btn btn-success"
							href="<s:url value="/departments/${department.getId()}" />"
							title="Detailed info"> see detail</a>  <a
							class="btn btn-warning"
							href="<c:url value="/departments/update/${department.getId()}" />">update</a>
							 <a class="btn btn-danger"
							href="<c:url value="/departments/delete/${department.getId()}" />">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<footer>
			<hr />
			<div class="navbar container">
				<p class="text-muted">&copy; 2017 David Larrea</p>
			</div>
		</footer>
	</div>

	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>