<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<style type="text/css">
     .centered {
        left: 50%; 
      }
</style>

<div class="container">
	<div class="navbar-header" style="height: 100px;">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/"><img src="/resources/images/common/CAMFLEX.png" alt="캠플렉스" height="80px;" width="110px;"></a>
	</div>
	<br>
	<br>
	<br>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/notice/noticeList">공지사항</a></li>
			<li><a href="/product/productList">예약</a></li>
			<li><a href="/member/memberDate">마이 페이지</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty id}">
			<li><a href="/login/login">로그인</a></li>
			<li><a href="/member/join">회원가입</a></li>
			</c:if>
			<c:if test="${!empty id}">
			<li><a href="/login/logout">로그아웃</a></li>
			</c:if>
		</ul>
	</div>
</div>
