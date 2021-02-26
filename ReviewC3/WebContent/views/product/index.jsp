<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/template" prefix="me"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<me:bg title="Trang Product">
<jsp:attribute name="content">
<div class="row">
<c:forEach items="${dsProduct }" var="p">
<div class="col-3">
<div class="item">
<img class="w-100 h-100" src="${pageContext.request.contextPath }/upload/${p.imageURL}">
</div>
<div class="info"><a>${p.title }</a></div>
</div>
</c:forEach>
</div>
</jsp:attribute>

</me:bg>