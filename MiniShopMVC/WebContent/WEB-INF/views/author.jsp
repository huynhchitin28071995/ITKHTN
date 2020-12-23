<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/template" prefix="me"%>
<me:bg title="Trang author">
<jsp:attribute name="content">
<a href="them">ADD AUTHOR</a>
<table style="width: 95%;margin: 0 auto; text-align:center">
<tr><th><button>Delete</button></th><th>ID</th><th>Tên Tác Giả</th><th>Chỉnh sửa thông tin tác giả</th><th>Xóa Tác giả</th></tr>
<c:forEach items="${dsAuthor}" var="a">
<tr>
<td><input type="checkbox" name="ids"></td>
<td>${a.authorId}</td>
<td>${a.authorName}</td>
<td><a href="edit/${a.authorId}">Chỉnh sửa thông tin</a>
<td><a href="delete?authorId=${a.authorId}">Xóa</a>
</tr>
</c:forEach>
</table>

</jsp:attribute>
</me:bg>