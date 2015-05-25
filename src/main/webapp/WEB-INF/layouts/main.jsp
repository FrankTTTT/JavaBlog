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
<title>Marlabs Test</title>
<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/examples/cover/cover.css"
	rel="stylesheet">

</head>

<body>
	<tilesx:useAttribute name="current" />
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Marlabs Test</h3>
						<nav>
							<ul class="nav masthead-nav">



								<li class="${current=='index'? 'active':''}"><a
									href='<spring:url value="/index.html" />'>Home</a></li>


								<security:authorize access="hasRole('ROLE_ADMIN')">
									<li class="${current=='users'? 'active':''}"><a
										href='<spring:url value="/users.html" />'>Users</a></li>
								</security:authorize>

								<security:authorize access="! isAuthenticated()">
																<li class="${current=='testDetail'? 'active':''}"><a
										href='<spring:url value="/test/testDetail.html" />'>Tests Choose</a></li>
									<li class="${current=='login'? 'active':''}"><a
										href='<spring:url value="/login.html" />'>Login</a></li>
									<li class="${current=='register'? 'active':''}"><a
										href='<spring:url value="/register.html" />'>Register</a></li>
									<li class="${current=='template'? 'active':''}"><a	href='<spring:url value="/test/template.html" />'>Template Test</a></li>
										
									
								</security:authorize>

								<security:authorize access="isAuthenticated()">

									<li class="${current=='users'? 'active':''}"><a
										href='<spring:url value="/account.html" />'>My account</a></li>
									
									
									
									
									
									
									
									<c:url value="/logout" var="logoutUrl" />

									
									<li class="${current=='logout'? 'active':''}">
									
									<div class="form-group form-control">
										<form action="${logoutUrl}" method="post">
										<input type="submit" value="Log out" /> <input type="hidden"
											name="${_csrf.parameterName}" value="${_csrf.token}" />
										</form>
									</div>
									
									
									</li>


									
									
								</security:authorize>
							</ul>
						</nav>
					</div>
				</div>

				<tiles:insertAttribute name="body" />

				<div class="mastfoot">
					<div class="inner">
						<p>
							Cover by <a href="http://getbootstrap.com">Frank</a>,
							by <a href="https://twitter.com/mdo">@Marlabs</a>.
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of 	the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>