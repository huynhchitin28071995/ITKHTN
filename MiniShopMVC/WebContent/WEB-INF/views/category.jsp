<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
<tr><th>Category ID</th><th> Category</th> <th>Parent ID</th></tr>
<c:forEach items="${dsCategory }" var="cat">
<tr>
<td>${cat.categoryId }</td>
<td> ${cat.categoryName }</td> 
<td>${cat.parentId }</td>
</tr>

</c:forEach>

</table>

