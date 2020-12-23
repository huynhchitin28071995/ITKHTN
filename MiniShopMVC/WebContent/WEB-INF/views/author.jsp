<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/template" prefix="me"%>
<me:bg title="Trang author">
<jsp:attribute name="content">
<a href="them">ADD AUTHOR</a>
<table>
<tr><th>ID</th><th>Tên Tác Giả</th></tr>
<c:forEach items="${dsAuthor}" var="a">
<tr><td>${a.authorId}</td><td>${a.authorName}</td></tr>
</c:forEach>
</table>

</jsp:attribute>
</me:bg>