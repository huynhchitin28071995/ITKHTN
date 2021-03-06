<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" modelAttribute="obj" cssClass="form">
<table>
<tr>
<td>Name</td><td><form:input path="categoryName"/></td>
</tr>
<tr>
<td>Parent</td><td>
<form:select path="parentId">
<form:option value="">--Select Parent--</form:option>
<form:options items="${mapParent }"/>
</form:select>
</td>
</tr>
<tr><td colspan="2" style="text-align: center"><button class="btn btn-primary">SAVE</button></td></tr>
</table>

</form:form>