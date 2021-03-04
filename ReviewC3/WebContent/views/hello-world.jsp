<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me" %>
hello world
<me:bg title="Hello World">
<jsp:attribute name="content">
<br>
<a href="${pageContext.request.contextPath }/sumtwonumbers.html">Tính tổng 2 số</a>
<br>
<a href="${pageContext.request.contextPath }/summultinumbers.html">Tính tổng Nhiều số</a>

</jsp:attribute>
</me:bg>
