<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<me:bg title="Thêm Tác giả">
<jsp:attribute name="content">
<form method="post" name="author">
<table style="width:95%; margin: 0 auto"> 
<tr><td> Name </td><td><input style="width:95%; margin: 0 auto" type="text" name="authorName""></td></tr>
<tr>
<td colspan="2" style="text-align: center"><button type="submit" name="btnSave">Save</button></td></tr>

</table>

</form>
<c:if test="${not empty msg }">${msg }</c:if>
</jsp:attribute>
</me:bg>