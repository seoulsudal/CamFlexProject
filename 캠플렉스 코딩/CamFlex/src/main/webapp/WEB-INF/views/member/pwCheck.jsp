<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 인증 페이지</title>
<script type="text/javascript">
	function password_check() {
		var p_RegExp = /^[a-zA-Z0-9]{8,20}$/; //비밀번호 유효성 검사 정규식

		var Pw = document.getElementById("m_pw"); //비밀번호

		//비밀번호 공백 입력여부 
		if (Pw.value == '') {
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		//비밀번호 유효성 
		if (!p_RegExp.test(Pw.value)) {
			alert("비밀번호는 8~20자의 영문 대소문자와 숫자로만 입력 해주세요! 다시 입력해주세요.");
			return false;
		}
	}
</script>
</head>
<body>
<div align="center">
	<h2>비밀번호 인증</h2>
	<br>
	<c:if test="${mvo == null }">
		<form id="PwCheck" name="PwCheck" action="pwCheck" method="POST"
			onsubmit="return password_check()">

			<div align="center" class="table">
				<label id="pwCheck_info">비밀번호</label> <input type="password"
					id="m_pw" name="m_pw" placeholder="비밀번호를 입력해주세요.">
			</div>
			<br>
			<div>
				<input type="submit" value="인증하기" class="btn btn-success"/>
			</div>
		</form>
	</c:if>
</div>
</body>
</html>