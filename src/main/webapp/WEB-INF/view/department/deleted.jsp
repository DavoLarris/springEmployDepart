<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<html>
<head>
<title>Deleted.jsp</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">Departments app</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<s:url value="/employees/" />" title="Employees">Employees</a></li>
				<li><a href="<s:url value="/employees/new" />"
					title="New employee">New employee</a></li>
				<li><a href="<s:url value="/departments/" />"
					title="Departments">Departments</a></li>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</nav>
	<div class="container">
		<h1>Ok, department ${departmentId} was deleted</h1>
	


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
