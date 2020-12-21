<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cộng 2 số</title>
</head>
<body>
<form method="post">
<p>Number a <input type="text" name="a" value="${a }"></p>
<p>Number b <input type="text" name="b" value="${b }"></p>
	<input type="submit" value="ADD" id="btnAdd"/>
</form>
<p>Kết quả <input type="text" name="txtKQ" value="${txtKQ }"></p>
</body>
</html>