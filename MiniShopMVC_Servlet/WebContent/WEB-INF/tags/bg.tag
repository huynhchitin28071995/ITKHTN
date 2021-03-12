<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}">Module 3</a></div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="${pageContext.request.contextPath}/helloworld.html">Hello World</a></li>
			<li><a href="${pageContext.request.contextPath}/sumtwonumbers.html">Sum Two Numbers</a></li>
			<li><a href="${pageContext.request.contextPath}/summultinumbers.html">Sum Multiple Numbers</a></li>
			<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
			<li><a href="${pageContext.request.contextPath}/views/login.jsp">Login</a></li>
			<li><a href="${pageContext.request.contextPath}/views/multiplicationtable.jsp">Multiplication Table</a></li>
			<li><a href="${pageContext.request.contextPath}/upload.html">Upload Image</a></li>
			<li><a href="${pageContext.request.contextPath}/upload/multi.html">Multiple Upload Image</a></li>
			<li><a href="${pageContext.request.contextPath}/views/template.jsp">Template Example</a></li>
			<li><a href="category.html">Category</a></li>
			<li><a href="${pageContext.request.contextPath}/sendmail.html">Send email</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/publisher.html">Publisher</a></li>
			<li><a href="${pageContext.request.contextPath}/publisher/add.html">Add Publisher</a></li>
		</ul>
	</div>
	<div class="main">
		<jsp:invoke fragment="content" />
	</div>
</body>
</html>
