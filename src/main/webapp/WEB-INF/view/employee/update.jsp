<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring forms :: Employees</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/validateUserForm.js" />"></script>
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
						title="See departments">Departments</a></li>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1>Update employee</h1>
		</div>

		<s:url var="action" value="/employees/saveUpdated" />
		<sf:form method="post" modelAttribute="employee"
			class="form-horizontal" action="${action}">
			<div class="form-group">
				<label for="id" class="control-label col-sm-1">Id</label>
				<div class="col-sm-11">
					<sf:input path="id" class="form-control" placeholder="ID" />
					<sf:errors path="id" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="control-label col-sm-1">Name</label>
				<div class="col-sm-11">
					<sf:input path="name" class="form-control" placeholder="Name" />
					<sf:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="birthDate" class="control-label col-sm-1">BirthDate</label>
				<div class="col-sm-11">
					<sf:input path="birthDate" class="form-control" type="date"
						placeholder="00-00-0000" />
					<sf:errors path="birthDate" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="telephone" class="control-label col-sm-1">Telephone</label>
				<div class="col-sm-11">
					<sf:input path="telephone" class="form-control" type="tel"
						placeholder="Telephone" />
					<sf:errors path="telephone" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-11">
					<sf:button type="submit" class="btn btn-default">Submit</sf:button>
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
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js">
		
	</script>
</body>
</html>
