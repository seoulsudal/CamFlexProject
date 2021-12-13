<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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

<!--  Custom styles for this template -->
<link href="/resources/include/dist/css/sticky-footer-navbar.css" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header"/>
	</nav>
	
	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<div class="jumbotron">
				<h1>과연 캠플렉스의 행방은..</h1>
				<p>To Be continued..</p>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6 col-lg-4">
				<h2>사진 or 멘트</h2>
			</div>
		</div>
	</div>
	
	<footer class="footer">
		<tiles:insertAttribute name="footer"/>
	</footer>
	
	<script src="/resources/include/dist/js/bootstrap.min.js"></script>
</body>
</html>