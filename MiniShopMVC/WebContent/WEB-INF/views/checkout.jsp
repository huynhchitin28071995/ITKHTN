<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="get" class="form" name="form-checkout" action="checkout">
<table>
<tr><td>Email</td><td><input type="email" name="email"></td></tr>
<tr><td>Tel</td><td><input type="tel" name="tel"></td></tr>
<tr><td>Address</td><td><input type="text" name="address"></td></tr>
</table>
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
<button class="btn">Check Out</button>
</form>