<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Upload image</h1>

<form class="form" method="post" enctype="multipart/form-data">
<p><label>Choose Image</label><input type="file" name="f" multiple="multiple"></p>
<button class="btn btn-primary">UPLOAD</button>
</form>
<c:if test="${not empty dsFile }">
<c:forEach items="${dsFile }" var="img">
<img style="width:100px" src="${pageContext.request.contextPath }/upload/${img }">
</c:forEach>
</c:if>
</body>
</html>