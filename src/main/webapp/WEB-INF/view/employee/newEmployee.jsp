<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
	<div class="container">
		<div class="jumbotron">
			<h1>New employee</h1>
			<p>See this employee info</p>
		</div>
		<c:url var="post_employee" value="/employees/new" />
		<sf:form method="post" modelAttribute="employee"
			class="form-horizontal" action="${post_employee}">
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
				<label for="department" class="control-label col-sm-1">Department</label>
				<div class="col-sm-11">
					<sf:select path="idDepartment" class="form-control">
						<sf:options items="${department}" itemLabel="id"
							itemValue="id" />
					</sf:select>
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