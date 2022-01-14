<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script type="text/javascript">
	function userLogin() {
		var e_RegExp = /\w+@\w+\.\w+(\.\w+)?/; //아이디(이메일) 정규식
		var p_RegExp = /^[a-zA-Z0-9]{8,20}$/; //비밀번호 유효성 검사 정규식

		var id = document.getElementById("m_id");//아이디
		var pw = document.getElementById("m_pw");//비밀번호

		/*===============아이디 유효성===============*/
		if (id.value == '') {
			alert("아이디를 입력해주세요.");
			id.focus();
			return false;
		}

		if (!e_RegExp.test(id.value)) {
			alert("아이디는 이메일 형식으로만 가능합니다! 다시 입력해주세요.");
			id.focus();
			return false;
		}
		/*===============비밀번호 유효성===============*/

		if (pw.value == '') {
			alert("비밀번호를 입력해주세요!");
			pw.focus();
			return false;
		}

		if (!p_RegExp.test(pw.value)) {
			alert("password는 8~20자의 영문 대소문자와 숫자로만 입력 해주세요.");
			pw.focus();
			return false;

		}
	}
</script>
</head>
<body>
	<h2>로그인</h2>
	<c:if test="${login == null }">
		<form id="loginCheck" name="loginCheck" action="/login/loginCheck"
			method="POST" onsubmit="return userLogin()">

			<div style="width: 350px">
				<input type="text" id="m_id" name="m_id"
					style="width: 305px; height: 35px;" placeholder="아이디를 입력해주세요.">
			</div>
			<p></p>
			<div style="width: 350px">
				<input type="password" id="m_pw" name="m_pw"
					style="width: 305px; height: 35px;" placeholder="비밀번호를 입력해주세요.">
			</div>
			<p></p>
			<div style="width: 350px">
				<input type="submit" value="로그인" style="width: 305px; height: 35px;"
					class="btn btn-success" />
			</div>
			<p></p>
			<div>
				<input type="button" value="아이디 찾기" class="btn"
					onClick="location.href='findId'" /> <input type="button"
					value="비밀번호 찾기" class="btn" onClick="location.href='findPw'" /> <input
					type="button" value="회원가입" class="btn"
					onClick="location.href='/member/join'" />
			</div>
		</form>
	</c:if>

</body>
</html>