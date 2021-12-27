<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 페이지</title>
<script type="text/javascript">
	function find_pw() {
	if(m_name.value='' || m_id.value='' || m_phone.value=''){
		alret("")
	}
	}
</script>
</head>
<body>
	<h2>비밀번호 찾기</h2>
	<c:if test="${mvo1 == null }">
		<form id="findPw" name="findPw" action="/login/findPw" method="POST" onsubmit="return find_pw()">
			<div>
				<label id="find_pw_info">이름</label><input type="text" id="m_name" name="m_name" placeholder="이름">
			</div>
			<p></p>
			<div>
				<label id="find_pw_info">아이디</label><input type="text" id="m_id" name="m_id" placeholder="아이디">
			</div>
			<p></p>
			<div>
				<label id="find_pw_info">전화번호</label><input type="text" id="m_phone" name="m_phone" placeholder="전화번호">
			</div>
			<p></p>

			<div>
				<input type="submit" value="비밀번호 찾기" />
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