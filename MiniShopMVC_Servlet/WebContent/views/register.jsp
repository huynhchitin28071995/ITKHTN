<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<label>Email</label>
<input type="text" name="email"> 
</p>
<p>
<label>Gender</label>
<select name="gender">
<option value="0">Male</option>
<option value="1">Female</option>
<option value="2">Undefined</option>
</select>
</p>
<p>
<button>Register</button>
</p>
</form>

<%if(request.getMethod().equals("POST")) { %>
	<p>User name: <%= request.getParameter("usr") %></p>
	<p>Pass word: <%= request.getParameter("pwd") %></p>
	<p>Email: <%= request.getParameter("email") %></p>
	<p>Gender: <%= request.getParameter("gender") %></p>
<%} %>

</body>
</html>