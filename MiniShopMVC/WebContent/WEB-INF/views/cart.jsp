<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
<tr><th>Title</th><th>Quantity</th><th>Price</th><th>Image</th><th>Delete</th>
</tr>
<c:forEach items="${carts}" var="o">
<tr>
<td>${o.title}</td>
<td><input type="number" value="${o.quantity}" name="qty"
class="qty"></td>
<td>${o.price}</td>
<td><img width="70px"
src="${pageContext.request.contextPath}/images/${o.imageUrl}" ></td>
<td><img src="${pageContext.request.contextPath}/images/trash.png"
></td>
</tr>
</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/cart/checkout.html" class="btn btnprimary">Check Out</a></p>
