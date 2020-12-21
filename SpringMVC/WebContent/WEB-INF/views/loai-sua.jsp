<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sữa</title>
</head>
<body>
<table border="1">
	<caption>DANH SÁCH LOẠI SỮA</caption>
	<tr>
		<th>Mã loại</th>
		<th>Tên loại</th>
	</tr>
	<c:forEach items="${dsls}" var="ls">
		<tr>
			<td>${ls.maLoai }</td>
			<td>${ls.tenLoai }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>