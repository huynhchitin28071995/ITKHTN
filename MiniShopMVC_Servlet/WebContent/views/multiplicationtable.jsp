<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<select name="num">
<c:forEach begin="0" end="10" step="1" var="i">
<option value="${i }">${i }</option>
</c:forEach>
</select>
<button>View</button>
</form>
<c:if test="${pageContext.request.method == 'POST' }">
<c:forEach begin="0" end="10" step="1" var="i">
<p>${i } x ${param.num } = ${param.num * i }</p>
</c:forEach>

</c:if>
</body>
</html>