<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div><h1>${product.title }</h1></div>
<div>
<form class="form-search">
<input type="text" name="txtSearch" placeholder="Search..." />
<button class="btn btn-primary">Search</button>
</form>
</div>