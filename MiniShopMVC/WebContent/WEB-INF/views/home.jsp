<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
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
			<li><a href="${pageContext.request.contextPath }/category/category">Category</a>
			<li><a href="${pageContext.request.contextPath }/category/add-category">Add-Category</a>
			<li><a href="${pageContext.request.contextPath }/product/xem">Product</a>
		</ul>
	</div>
	<div class="main">
		<tiles:insertAttribute name="noiDung"/>
	</div>
</body>
</html>
