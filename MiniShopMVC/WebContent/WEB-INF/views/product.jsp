<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${dsProduct}" var="p">
<div class="">
<img src="${application.realPath}/images/${p. imageUrl}" alt=""/>
<p>${p.title }</p>
<p>${pageContext.request.contextPath}/images/${p. imageUrl}</p>
</div>
</c:forEach>