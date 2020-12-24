<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="products">
	<c:forEach items="${dsProduct}" var="p">
		<div class="col-4">
			<div class="item">

				<img src="${pageContext.request.contextPath}/images/${p.imageUrl}"
					alt="${p.title }" />
				<div class="info">
					<p>${p.title }</p>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="clear"></div>
</div>

<!-- Chia trang -->
<ul class="pagination">
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem">&#60;&#60;</a></li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai-1}">&#60;</a></li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai-1}">...</a></li>
	<c:forEach begin="1" end="${tongSoTrang }" step="1" var="i">
		<c:choose>
			<c:when test="${trangHienTai==i }">
				<li class="page-item"><a class="page-link"
					style="font-weight: bold;"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>


			<c:when test="${i - trangHienTai > 1 }">
				<li hidden class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">...</a>
				</li>
			</c:when>


			<c:when test="${i - trangHienTai < -1 }">
				<li hidden class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">...</a>
				</li>
			</c:when>


			<c:when test="${trangHienTai != i }">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>




		</c:choose>
	</c:forEach>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai-1}">...</a></li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai+1}">&#62;</a>
	</li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${tongSoTrang}">&#62;&#62;</a>
	</li>
</ul>