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
<title>Spring forms :: Employees</title>

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
					<li><a href="<s:url value="/employees/" />" 
					title="<s:message code="navbar.employees"></s:message>"><s:message
								code="navbar.employees"></s:message></a></li>
					<li><a href="<s:url value="/employees/new" />"
						title="<s:message code="navbar.newEm"></s:message>"><s:message
								code="navbar.newEm"></s:message></a></li>
					<li><a href="<s:url value="/departments/" />"
						title="<s:message code="navbar.depart"></s:message>"><s:message
								code="navbar.depart"></s:message></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="true"><s:message
								code="navbar.language"></s:message> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="?locale=en"><img src="blank.gif"
									class="flag flag-gb"
									alt="<s:message code="english"></s:message>" /> <s:message
										code="english"></s:message></a></li>
							<li><a href="?locale=es"><img src="blank.gif"
									class="flag flag-es"
									alt="<s:message code="spanish"></s:message>" /> <s:message
										code="spanish"></s:message></a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="jumbotron">
			<h1>Employees list</h1>
			<p>These are the employees currently in the system.</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>BirthDate</th>
					<th>Telephone</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.getName()}</td>
						<td>${employee.getBirthDate()}</td>
						<td>${employee.getTelephone()}</td>
						<td><a class="btn btn-success"
							href="<s:url value="/employees/${employee.getId()}" />"
							title="Detailed info"> see detail</a>  <a
							class="btn btn-warning"
							href="<c:url value="/employees/update/${employee.getId()}" />">update</a>
							 <a class="btn btn-danger"
							href="<c:url value="/employees/delete/${employee.getId()}" />">delete</a></td>
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