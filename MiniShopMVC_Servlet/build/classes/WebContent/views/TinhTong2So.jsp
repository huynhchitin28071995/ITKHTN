<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me"%>
<me:bg title="Tổng 2 số">
<jsp:attribute name="content">
<form>

<table>
<tr>
<td>Số 1:</td>
<td><input type="text" name="numA"></td>
</tr>
<tr>
<td>Số 2:</td>
<td><input type="text" name="numB"></td>
</tr>
<tr>
<td colspan="2"><button>Cộng</button></td>
</tr></table>
</form>
</jsp:attribute>
</me:bg>