<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/template" prefix="me"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<me:bg title="Add Publisher">
<jsp:attribute name="content">
<form method="post" class="form">
<div class="row">
<div class="col-4">
Publisher Name
</div>
<div class="col-8">
<input type="text" name="publisherName">
</div>
<div class="col-12 text-center">
<button class="btn-primary">ADD</button>
</div>
</div>

</form>
<c:if test="${not empty msg }">
	${msg }
</c:if>
</jsp:attribute>

</me:bg>