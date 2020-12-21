<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Thêm Loại sữa</h1>
<form action="them" method="post">
	<p>Mã loại: <input type="text" name="maLoai" value="${maLoai }"></p>
	<p>Tên loai: <input type="text" name="tenLoai" value="${tenLoai }"></p>
	<p><button type="submit">Thêm</button></p>
</form>
<c:if test="${not empty msg }">
${msg }
</c:if>
</body>
</html>