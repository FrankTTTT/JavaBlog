<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	
</head>
<body>

	<tilesx:useAttribute name="current" />

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="http://www.marlabs.com/">Marlabs Online Test System</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current=='index'? 'active':''}"><a	
							href='<spring:url value="/index.html" />'>Home</a></li>
							
						<li class="${current=='index'? 'active':''}"><a	
							href='<spring:url value="/main.html" />'>Main</a></li>
							
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current=='users'? 'active':''}"><a
								href='<spring:url value="/users.html" />'>Users</a></li>
						</security:authorize>

						<security:authorize access="! isAuthenticated()">
							<li class="${current=='login'? 'active':''}"><a
								href='<spring:url value="/login.html" />'>Login</a></li>
							<li class="${current=='register'? 'active':''}"><a
								href='<spring:url value="/register.html" />'>Register</a></li>
						</security:authorize>

						<security:authorize access="isAuthenticated()">

							<li class="${current=='users'? 'active':''}"><a
								href='<spring:url value="/account.html" />'>My account</a></li>

							<%-- <li> <a href="<c:url var="logoutUrl" value="/logout"/>">Log out</a></li> --%>

							<c:url var="logoutUrl" value="/logout" />
							<form action="${logoutUrl}" method="post">
								<input type="submit" value="Log out" /> <input type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
			

						</security:authorize>

					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<!-- this is for navigation -->
		<tiles:insertAttribute name="body" />
	</div>
	<!-- /container -->

	

	<br>
	<br>

	<center>
		<tiles:insertAttribute name="footer" />
	</center>

</body>
</html>