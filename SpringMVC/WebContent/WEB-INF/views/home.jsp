<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Spring MVC</title>
<style type="text/css">
a{
diplay:block;
}

</style>
</head>
<body>
<h1>Chào mừng bạn đến với lập trình Spring MVC</h1>
<a href="${pageContext.request.contextPath }/loaisua/them">Them loai sua</a>
<a href="${pageContext.request.contextPath }/loaisua/danh-sach">Danh sách loại sữa</a>
<a href="${pageContext.request.contextPath }/sum/cong2so">Cộng 2 số</a>
<a href="${pageContext.request.contextPath }/congnhieuso">Cộng nhiều số</a>
</body>
</html>