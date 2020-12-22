<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<table border="1">
	<caption>DANH SÁCH LOẠI SỮA TÌM</caption>
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
