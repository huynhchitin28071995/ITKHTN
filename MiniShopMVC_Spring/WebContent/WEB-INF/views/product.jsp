<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
var i = 2;
var j = 2;
var tongSoTrang=parseInt('${tongSoTrang}');
var trang = parseInt('${trangHienTai}');	
function showPrevPages() {
	j=2;

	if(trang - i === 1) {
		trang  = 1 + i;
		document.getElementById("morePrevPages").style.display="none"
		} 
	var pageNum = document.getElementById("page" + (trang - i));	
	i = i + 1;	
	console.log(trang-i);
	pageNum.style.display = "inline";
}
function showNextPages() {
	i = 2;

	if(trang + j === tongSoTrang ) 
		{
			trang = tongSoTrang - j;
			document.getElementById("moreNextPages").style.display="none";
		}
	var pageNum = document.getElementById("page" + (trang + j));	
	j = j + 1;	
	console.log("i = " + i);
	console.log(trang+j);
	pageNum.style.display = "inline";
}
function trangDau() {
	if(trang===1) {
		console.log("trang 1");
		document.getElementById("morePrevPages").style.display="none";
	} else {
	console.log("trang #1");
		}
}
</script>
<div class="products">
	<c:forEach items="${dsProduct}" var="p">
		<div class="col-4">
			<div class="item">

				<img src="${pageContext.request.contextPath}/images/${p.imageUrl}"
					alt="${p.title }" />
				<div class="info">
					<p><a href="${pageContext.request.contextPath}/product/chi-tiet?productId=${p.productId}">${p.title }</a></p>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="clear"></div>
</div>

<!-- Chia trang -->
<ul class="pagination" >
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem">&#60;&#60;</a></li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai-1}">&#60;</a></li>
	<c:if test="${trangHienTai != 1 }"><li class="page-item page-link" id="morePrevPages" onclick="showPrevPages()">...</li></c:if>
	
	<c:forEach begin="1" end="${tongSoTrang }" step="1" var="i">
		<c:choose>
			<c:when test="${trangHienTai==i }">
				<li class="page-item" id="page${i }"><a class="page-link" style="font-weight: bold;"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>


			<c:when test="${i - trangHienTai > 1 }">
				<li style="display: none;" class="page-item" id="page${i }"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>


			<c:when test="${i - trangHienTai < -1 }">
				<li style="display: none;" class="page-item" id="page${i }"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>


			<c:when test="${trangHienTai != i }">
				<li class="page-item"  id="page${i }"><a class="page-link"
					href="${pageContext.request.contextPath }/product/xem/${i }">${i}</a>
				</li>
			</c:when>




		</c:choose>
	</c:forEach>
	<c:if test="${trangHienTai!=tongSoTrang }"><li class="page-item page-link" id="moreNextPages" onclick="showNextPages()">...</li></c:if>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${trangHienTai+1}">&#62;</a>
	</li>
	<li class="page-item"><a class="page-link"
		href="${pageContext.request.contextPath }/product/xem/${tongSoTrang}">&#62;&#62;</a>
	</li>
</ul>