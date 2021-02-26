<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<me:bg title="Publisher">
<jsp:attribute name="content">
<div class="page-header">Manage Publisher</div>
	<p><a href="${pageContext.request.contextPath }/publisher/add.html">Add new publisher</a></p>
	<form action="${pageContext.request.contextPath }/publisher/dels.html">
		<button class="btn btn-primary">Delete</button>	
		<table class="table">
		<tr>
		<th>Check</th>
		<th>STT</th>
		<th>Ten</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
		<c:forEach items="${dsPublisher }" var="publisher">
		<tr>
		<td><input type="checkbox" value="${publisher.publisherId }"></td>
		<td>${publisher.publisherId }</td>
		<td>${publisher.publisherName }</td>
		<td><a href="${pageContext.request.contextPath }/publisher/edit.html?publisherId=${publisher.publisherId}"><img src="${pageContext.request.contextPath }/images/edit.png"></a>
		<td><a href="${pageContext.request.contextPath }/publisher/del.html?publisherId=${publisher.publisherId}"><img src="${pageContext.request.contextPath }/images/trash.png"></a>
		</tr>
		
		</c:forEach>
		
		</table>
	</form>
</jsp:attribute>
</me:bg>