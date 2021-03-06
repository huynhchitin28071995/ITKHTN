<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="/WEB-INF/template" prefix="me"%>


<me:bg title="">
<jsp:attribute name="content">
<form method="post" class="form">
<h3 class="page-header">Send Email</h3>
<p>
	<label for="email">Email</label>
	<input type="text" class="col-7" name="email" />
</p>
<p><label for="subject">Subject</label><input type="text" class="col-7" name="subject"></p>
<p><label for="content">Content</label><textarea rows="5" cols="20" class="col-7" name="content"></textarea></p>
<button class="btn btn-primary">Send</button>
</form>
<c:if test="${not empty msg }">
<div class="error">${msg }, email: ${param.email} </div>
</c:if>
</jsp:attribute>

</me:bg>
