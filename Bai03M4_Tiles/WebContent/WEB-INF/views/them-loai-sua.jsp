<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Thêm Loại sữa</h1>
<form action="them" method="post">
	<p>Mã loại: <input type="text" name="txtMaLoai" value="${maLoai }"></p>
	<p>Tên loai: <input type="text" name="txtTenLoai" value="${tenLoai }"></p>
	<p><button type="submit">Thêm</button></p>
</form>
