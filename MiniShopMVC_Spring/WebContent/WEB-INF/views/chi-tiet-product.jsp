<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div><h1>${product.title }</h1></div>
<div>
<form action="${pageContext.request.contextPath}/product/search" class="form-search">
<input type="text" name="txtSearch" placeholder="Search..." />
<button class="btn btn-primary">Search</button>
</form>
<div class="col-4">
<img src="${pageContext.request.contextPath }/images/${product.imageUrl}">

</div>
<div class="clear"></div>
<div class="col-8">
<h2>${product.title }</h2>
<p>ISBN: <b>${product.isbn }</b>
<p>Pages: <b>${product.pages }</b>
<p>Price: <b>${product.price }</b>
<form method="get" action="${pageContext.request.contextPath }/cart/them-cart" name="somethingelsethanobj">
<input type="hidden" value="${product.productId }" name="productId"/>
<input type="number" name="quantity" value="1"/>
<button class="btn btn-primary">Add to Cart</button>
</form>
</div>
</div>