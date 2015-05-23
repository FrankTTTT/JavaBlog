<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../layouts/taglib.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='<spring:url value="/test/back-end/core-java.html" />'>Core java</a><br>
	<a href="">JDBC</a><br>
	<a href="">Servlet</a><br>
	<a href="">Spring</a><br>
	<a href="">Hibernate</a><br>
	<a href="">strcts</a><br>
	
	
<div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="..." alt="...">
    </a>
  </div>
  
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="..." alt="...">
    </a>
  </div>
  
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="..." alt="...">
    </a>
  </div>
  
  <div class="col-xs-6 col-md-3">
	<a href='<spring:url value="/test/front-end.html" />' class="thumbnail"><img src="<c:url value="/images/image.png" />" alt="" /></a>
  </div>
  
</div>
</body>
</html>