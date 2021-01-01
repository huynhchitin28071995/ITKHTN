<%-- 
    Document   : tim-kiem-sua
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page4" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
    <form name="frmTimKiem" action="trang-tim-kiem-sua.jsp" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>TÌM KIẾM THÔNG TIN SỮA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Loại sữa: 
                        <select name="cboLoaiSua">
                            <c:forEach var="i" begin="1" end="5" step="1">
                                <option value="${i}">Tên loại sữa ${i}</option>
                            </c:forEach>
                        </select>
                        Hãng sữa:
                        <select name="cboHangSua">
                            <c:forEach var="i" begin="1" end="5" step="1">
                                <option value="${i}">Tên hãng sữa ${i}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tên sữa: <input type="text" name="txtTenSuaTim" value="" size="30"/>
                        <input type="submit" value="Tìm kiếm" name="btnTimKiem"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <%--<c:if test="${sosp>0}">--%>
        <p><b>Có 2 sản phẩm được tìm thấy</b></p>
        <table border="0">
            <c:forEach var="i" begin="1" end="2" step="1">
            <thead>
                <tr>
                    <th colspan="2" class="tieu-de-sua">Tên sữa tìm thấy</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="./images/AB007.jpg"></td>
                    <td>
                        <p><b>Thành phần dinh dưỡng:</b><br>Sữa không béo, dầu thực vật, đường lactose, đường ...</p>
                        <p><b>Lợi ích:</b><br>Sữa bột Gain Advance sữa bột tiếp theo giàu đạmTPA...</p>
                        <fmt:formatNumber type="number" value="250000" var="donGia"/>
                        <p><b>Trọng lượng:</b> ${stt.trongluong} gr - <b>Đơn giá:</b> ${donGia} đ</p>
                    </td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    <%--</c:if>--%>
    </div>
</div>