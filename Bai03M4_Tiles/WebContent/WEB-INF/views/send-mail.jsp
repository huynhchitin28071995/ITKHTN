<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form method="post" class="form" >
	<p>
		<label>From: </label>
		<input type="email" name="from">
	</p>
	<p>
		<label>Password: </label>
		<input type="password" name="password">
	</p>
	<p>
		<label>Email</label>
		<input type="email" name="email">
	</p>
	<p>
		<label>Subject</label>
		<input type="text" name="subject" />
	</p>
	<p>
		<label>Content</label>
		<textarea name="content"></textarea>
		
	</p>
	<p><button>Send mail</button></p>
</form>
<c:if test="${not empty msg }">
	<div class="error">${msg}</div>
</c:if>
