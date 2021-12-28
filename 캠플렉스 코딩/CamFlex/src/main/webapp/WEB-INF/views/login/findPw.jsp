<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function find_pw() {
	if(m_name.value= '' || m_id.value= '' || m_phone.value=''){
		alret("")
	}
	}
</script>
</head>
<body>
	<h2>비밀번호 찾기</h2>
	<c:if test="${mvo1 == null }">
		<form id="findPw" name="findPw" action="/login/findPw" method="POST" onsubmit="return find_pw()">
			<div class="form-group" style="width: 280px">
				<label id="find_pw_info">이름</label><input type="text" class="form-control" id="m_name" name="m_name" placeholder="이름">
			</div>
			<div class="form-group" style="width: 280px">
				<label id="find_pw_info">아이디</label><input type="text" class="form-control" id="m_id" name="m_id" placeholder="아이디">
			</div>
			<div class="form-group" style="width: 280px">
				<label id="find_pw_info">전화번호</label><input type="text" class="form-control" id="m_phone" name="m_phone" placeholder="전화번호">
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="비밀번호 찾기" />
			</div>
		</form>
	</c:if>
	
	<c:if test="${mvo1 != null}">
		<div>
			<p>${mvo1.m_name}님${mvo1.m_id}아이디의비밀번호는</p>
			<p>' ${mvo1.m_pw} ' 입니다.</p>
		</div>
		
		<div>
			<a href="/login/login">로그인 페이지로 이동하기</a>
		</div>
	</c:if>
</body>
</html>