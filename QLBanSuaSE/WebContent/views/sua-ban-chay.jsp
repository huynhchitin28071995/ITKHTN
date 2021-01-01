<%-- 
    Document   : sua-ban-chay
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach var="i" items="${dsSuaBanChay }">
                <li><a href="trang-sua-ban-chay.jsp?maSua=${i.maSua}">Sữa bán chạy: ${i.tenSua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
            <tr>
                <td colspan="2" class="tieu-de-sua">Sữa bán chạy 1</td>
            </tr>
            <tr>
                <td><img src="./images/AB007.jpg"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>Sữa không béo, dầu thực vật, đường lactose, đường ...</p>
                    <p><b><i>Lợi ích:</i></b><br>Sữa bột Gain Advance sữa bột tiếp theo giàu đạmTPA...</p>
                    <fmt:formatNumber value="150000" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> 300 gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>