<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" class="form">
<p>
<label>Username</label>
<input type="text" name="usr"> 
</p>
<p>
<label>Password</label>
<input type="password" name="pwd"> 
</p>
<p>
<button>Login</button>
</p>
</form>
<c:if test="${pageContext.request.method == 'POST'}">
<p>User name: ${param.usr }</p>
<p>Password: ${param.pwd }</p>
</c:if>
</body>
</html>