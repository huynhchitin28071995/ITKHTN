<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<me:bg title="Chi tiết sản phẩm">
<jsp:attribute name="content">
<div class="row">
<c:if test="${not empty product}">
	<form class="form-search" method="get" 
action="${pageContext.request.contextPath}/home/search.html">
<input type="text" placeholder="Search..." name="q" >
<button class="btn btn-primary">Search</button>
</form>
<div class="page-header">
Product Detail
</div>
<div class="products">
<div class="col-5">
<img 
src="${pageContext.request.contextPath}/upload/${product.imageURL}">
</div>
<div class="col-7">
<h2>${product.title}</h2>
<p>ISBN: <b>${product.isbn}</b></p>
<p>Pages: <b>${product.pages}</b></p>
<p>Price: <b>${product.price}</b></p>
<form method="post" 
action="${pageContext.request.contextPath}/cart.html">
<input type="hidden" value="${product.productId}" name="productId" >
<input type="number" name="qty" value="1">
<button class="btn btn-primary">Add to Cart</button>
</form>
</div>
</div>
</c:if>
</div>
</jsp:attribute>
</me:bg>