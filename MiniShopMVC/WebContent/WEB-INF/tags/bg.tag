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
			<div class="brand"><a href="${pageContext.request.contextPath}">MiniShop Module 3</a></div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="${pageContext.request.contextPath }/home">Home</a></li>
			<li><a href="${pageContext.request.contextPath }/publisher">Publisher</a></li>
			<li><a href="${pageContext.request.contextPath }/author/xem">Author</a>
		</ul>
	</div>
	<div class="main">
		<jsp:invoke fragment="content" />
	</div>
</body>
</html>
