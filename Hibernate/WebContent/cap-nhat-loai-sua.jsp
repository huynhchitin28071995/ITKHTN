<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>C?p nh?t lo?i s?a</title>
    </head>
    <body>
        <form name="frmLoaiSua" action="CapNhatLoaiSuaServlet" method="post">
            <table border="0">
                <caption>C?P NH?T LO?I S?A</caption>
                <tbody>
                    <tr>
                        <td>Mã lo?i</td>
                        <td><input type="text" name="txtMaLoai" value="${loaiSua.maLoaiSua}" /></td>
                    </tr>
                    <tr>
                        <td>Tên lo?i</td>
                        <td><input type="text" name="txtTenLoai" value="${loaiSua.tenLoai}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        	<button value="them" name="btnChon">Thêm</button>
                        	<button value="tim" name="btnChon">Tìm</button>
                        	<button value="sua" name="btnChon">S?a</button>
                        	<button value="xoa" name="btnChon">Xóa</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        <table border="1">
            <caption>DANH SÁCH LO?I S?A</caption>
            <thead>
                <tr>
                    <th>Mã lo?i</th>
                    <th>Tên lo?i</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsls}" var="ls">
                    <tr>
                        <td>${ls.maLoaiSua}</td>
                        <td>${ls.tenLoai}</td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
    