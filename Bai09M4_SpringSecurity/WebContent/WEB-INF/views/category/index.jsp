<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">List Category</div>
<a href="${pageContext.request.contextPath}/admin/category/add.html" class="btn btn-primary">Add</a>

<table class="table table-bordered">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${list}" var="o">
		<tr>
			<td>${o.id}</td>
			<td>${o.name}</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/category/edit.html/${o.id}">
					<img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit">
				</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/category/del.html/${o.id}">
					<img src="${pageContext.request.contextPath}/images/trash.png" alt="Delete">
				</a>
			</td>
		</tr>
	</c:forEach>
</table>