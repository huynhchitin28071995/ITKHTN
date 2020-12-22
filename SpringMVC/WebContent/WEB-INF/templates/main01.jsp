<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="tieuDe"/></title>
<style type="text/css">
	nav{
		width:20%;
		float:left;
	}
	article{
		width:80%;
		float:left;
	}
	footer{
		clear: both;
	}
</style>
</head>
<body>
<header>
	<tiles:insertAttribute name="dauTrang"/>
</header>
<section>
	<nav>
		<tiles:insertAttribute name="thucDon"/>
	</nav>
	<article>
		<tiles:insertAttribute name="noiDung"/>
	</article>
</section>
<footer>
	<tiles:insertAttribute name="cuoiTrang"/>
</footer>
</body>
</html>