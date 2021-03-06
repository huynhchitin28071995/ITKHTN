<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}">Mini Shop</a></div>
			<div class="nav-right">
				<ul>
					<li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
					<li><a href="${pageContext.request.contextPath}/auth/logon.html">Log On</a></li>
					<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
					<li>
Welcome <span>${pageContext.request.userPrincipal.name}</span>
<form class="form-hidden" method="post"
action="${pageContext.request.contextPath}/auth/logoff.html">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<button>Log Off</button>
</form>
</li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
				<ul>
					<c:forEach items="${dsCategory}" var="o">
						<c:if test="${o.parentId eq 0}">
							<li>${o.categoryName}</li>
							<ul>
							<c:forEach items="${dsCategory}" var="child">
								<c:if test="${child.parentId eq o.categoryId}">
									<li><a href="${pageContext.request.contextPath}/product/chi-tiet?productId=${child.categoryId}">${child.categoryName}</a></li>
								</c:if>
							</c:forEach>
							</ul>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="col-9">
			<tiles:insertAttribute name="noiDung"/>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>