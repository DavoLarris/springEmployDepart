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

</head>
<body>

	<a href="#">Users app</a>

	<ul>
		<li><a href="<s:url value="/employees/" />"
			title="View employees">View employees</a></li>
		<li><a href="<s:url value="/employees/new" />"
			title="New employee">New employees</a></li>
		<li><a href="<s:url value="/departments/" />"
			title="See departments">Departments</a></li>
	</ul>

	<h1>User created</h1>

	<div class="alert alert-success" role="alert">The following
		employee has been created successfully</div>
	<table class="table">
		<thead>
			<tr>
			<th>Id</th>
				<th>Name</th>
				<th>BirthDate</th>
				<th>Telephone</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td>${employee.getId()}</td>
				<td>${employee.getName()}</td>
				<td>${employee.getBirthDate()}</td>
				<td>${employee.getTelephone()}</td>
			</tr>
		</tbody>
	</table>

	<p class="text-muted">&copy; 2017 David Larrea</p>

</body>
</html>