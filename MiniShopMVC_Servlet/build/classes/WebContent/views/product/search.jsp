<%@taglib prefix="me" uri="/WEB-INF/template" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<me:bg title="Trang tìm kiếm sản phẩm">
<jsp:attribute name="content">
<form class="form-search" method="get" 
action="${pageContext.request.contextPath}/home/search.html">
<input type="text" placeholder="Search..." name="q" >
<button class="btn btn-primary">Search</button>
</form>
<div class="page-header">
Search Result
</div>
<div class="products">
<c:forEach var="product" items="${dsProduct}">
<div class="col-3">
<a 
href="${pageContext.request.contextPath}/product-detail.html?productId=${product.productId}">
<div class="item">
<img alt="${product.title}" 
src="${pageContext.request.contextPath}/upload/${product.imageURL}">
<div class="info">
${product.title}
</div>
</div></a>
</div>
</c:forEach>
<div class="clear"></div>
</div>
<c:if test="${not empty dsProduct }"> 
<div class="pagination">
<c:forEach begin="1" end="${numOfPages }" step="1" var="i">
<li class="page-item">
<a class="page-link" href="${pageContext.request.contextPath}/home/search.html?page=${i}&q=${searchInput}">
${i }
</a>
</li>
</c:forEach>
</div>
</c:if>
</jsp:attribute>
</me:bg>