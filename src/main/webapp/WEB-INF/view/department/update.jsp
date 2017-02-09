<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Update.jsp</title>
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
			<h1>Update user</h1>
		</div>

		<s:url var="action" value="/departments/saveupdate" />
		<sf:form class="form-horizontal" method="post" action="${action}"
			modelAttribute="department">
			<div class="form-group">
				<label for="id" class="control-label col-sm-1">Id</label>
				<div class="col-sm-11">
					<sf:input path="id" class="form-control" readonly="true"
						placeholder="Id" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="control-label col-sm-1">Name</label>
				<div class="col-sm-11">
					<sf:input path="name" class="form-control" type="text"
						placeholder="Name" />
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="control-label col-sm-1">Description</label>
				<div class="col-sm-11">
					<sf:textarea path="description" class="form-control"
						placeholder="Description" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-11">
					<sf:button class="btn btn-default">Update</sf:button>
				</div>
			</div>
		</sf:form>

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
