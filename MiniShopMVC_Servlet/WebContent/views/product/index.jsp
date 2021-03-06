<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/template" prefix="me"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<me:bg title="Trang Product">
<jsp:attribute name="content">
<form class="form-search" action="${pageContext.request.contextPath }/home/search.html" method="get">
<input type="text" placeholder="Search..." name="q">
<button class="btn-primary">SEARCH</button>
</form>
<div class="page-header">
Products
</div>
<div class="products">
<c:forEach items="${dsProduct }" var="p">
<div class="col-3">
<div class="item" style='height: 400px'>
<img src="${pageContext.request.contextPath }/upload/${p.imageURL}" style="height: 80%">
<div class="info"><a>${p.title }</a></div>
</div>

</div>
</c:forEach>
<div class="clear"></div>
</div>
<ul class="pagination">
<c:forEach begin="1" end="${numOfPages }" step="1" var="i">
<li class="page-item">
<a class="page-link" href="${pageContext.request.contextPath}/home.html?page=${i}">
${i }
</a>
</li>

</c:forEach>

</ul>
</jsp:attribute>

</me:bg>