<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a href="them">ADD AUTHOR</a>
<form action="xoaNhieu" method="post">
<table style="width: 95%;margin: 0 auto; text-align:center">
<tr><th><button>Delete</button></th><th>ID</th><th>Tên Tác Giả</th><th>Chỉnh sửa thông tin tác giả</th><th>Xóa Tác giả</th></tr>
<c:forEach items="${dsAuthor}" var="a">
<tr>
<td><input type="checkbox" name="ids" value="${a.authorId }"></td>
<td>${a.authorId}</td>
<td>${a.authorName}</td>
<td><a href="edit/${a.authorId}">Chỉnh sửa thông tin</a>
<td><a href="delete?authorId=${a.authorId}">Xóa</a>
</tr>
</c:forEach>
</table>
</form>
