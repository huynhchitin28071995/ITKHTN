<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách s?a</title>
</head>
<body>
<table border="1">
	<caption>DANH SÁCH S?A</caption>
	<tr>
		<th>Tên s?a</th>
		<th>Hãng s?a</th>
		<th>Lo?i s?a</th>
		<th>Tr?ng lu?ng</th>
		<th>Ðon giá</th>
	</tr>
	<c:forEach items="${dsSua}" var="s">
		<tr>
			<td>${s.tenSua }</td>
			<td>${s.hangSua.tenHangSua }</td>
			<td>${s.loaiSua.tenLoai }</td>
			<td>${s.trongLuong }</td>
			<td>${s.donGia }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>