<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/resources/images/common/icon.png">
<title><tiles:getAsString name="title"/></title>

<!-- Bootstrap core CSS -->
<link href="/resources/include/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="/resources/include/dist/css/sticky-footer-navbar.css" rel="stylesheet">

<!--  Custom styles for this template -->
<link href="/resources/include/dist/css/dashboard.css" rel="stylesheet">

<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>

<script type="text/javascript" src="/resources/include/js/common.js"></script>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header"/>
	</nav>
	<br>
	<div class="container">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<tiles:insertAttribute name="aside"/>
			</div>
			<div class="col-sm-9">
				<tiles:insertAttribute name="body" ignore="true"/>			
			</div>
		</div>
	</div>
	
	<footer class="container-fluid">
		<tiles:insertAttribute name="footer"/>
	</footer>
	
	<script src="/resources/include/dist/js/bootstrap.min.js"></script>
	<script src="/resources/include/dist/assets/js/docs.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>