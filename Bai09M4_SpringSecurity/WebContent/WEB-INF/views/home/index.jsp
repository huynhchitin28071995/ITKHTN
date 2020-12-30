<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>Spring Security</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath}/home/index.html">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/logon.html">Logon</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/author/index.html">Author</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/category/index.html">Category</a></li>
		<li><a href="${pageContext.request.contextPath}/user/hello.html">Hello</a></li>
	</ul>
	<h2>Welcome	<span>${pageContext.request.userPrincipal.name}</span></h2>
	<form class="form-hidden" method="post"
		action="${pageContext.request.contextPath}/auth/logoff.html">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>Log Off</button>
	</form>
</body>
</html>