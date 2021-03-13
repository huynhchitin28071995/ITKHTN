<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/template" prefix="me" %>
<me:bg title="Cart">
<jsp:attribute name="content">
<div class="page-header">
<div>Your Cart</div>
</div>
<table class="table table-bordered">
<tr><th>Title</th><th>Quantity</th><th>Price</th><th>Image</th><th>Delete</th></tr>
<c:forEach items="${list}" var="o">
<tr>
<td>${o.value.title}</td>
<td><input type="number" value="${o.value.quantity}" 
name="qty" class="qty"></td>
<td>${o.value.price}</td>
<td><img width="70px" 
src="${pageContext.request.contextPath}/upload/${o.value.imageUrl}" ></td>
<td><img 
src="${pageContext.request.contextPath}/images/trash.png" ></td>
</tr>
</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/cart/checkout.html" 
class="btn btn-primary">Check Out</a></p>
</jsp:attribute>
</me:bg>