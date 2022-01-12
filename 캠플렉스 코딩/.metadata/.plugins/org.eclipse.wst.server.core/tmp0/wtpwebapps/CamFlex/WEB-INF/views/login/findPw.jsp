<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 페이지</title>
<script type="text/javascript">
	function find_password() {
		var n_RegExp = /^[가-힣a-zA-Z]{0,50}$/; //이름 특수문자 사용불가 정규식(한글,영문만 가능)
		var e_RegExp = /\w+@\w+\.\w+(\.\w+)?/; //아이디(이메일) 유효성 검사 정규식
		var t_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;//전화번호 유효성 검사 정규식

		var name = document.getElementById("m_name");
		var id = document.getElementById("m_id");
		var phone = document.getElementById("m_phone");

		/*===============name 유효성===============*/
		if (name.value == '') {
			alert("이름을 입력해주세요.");
			name.focus();
			return false;
		}
		if (!n_RegExp.test(name.value)) {
			alert("이름에 특수문자,숫자는 입력할수 없습니다. 다시 입력해주세요.");
			name.focus();
			return false;
		}

		/*===============ID 유효성===============*/
		if (id.value == '') {
			alert("아이디을 입력해주세요.");
			id.focus();
			return false;
		}

		if (!e_RegExp.test(id.value)) {
			alert("아이디는 이메일 형식으로만 가능합니다! 다시 입력해주세요.");
			id.focus();
			return false;
		}

	}
</script>
<body>
	<h2>비밀번호 찾기</h2>
	<form name="findPw" id="findPw" action="/login/findPw" method="POST" onsubmit="return find_password()">
		<div>
			<label id="find_pw_info">이름</label> <input type="text" id="m_name"
				name="m_name" placeholder="이름">
		</div>
		<p></p>
		<div>
			<label id="find_pw_info">아이디</label> <input type="text" id="m_id"
				name="m_id" placeholder="아이디">
		</div>
		<p></p>

		<div>
			<input type="submit" value="비밀번호 찾기" class="btn btn-success"/>
		</div>
	</form>
</body>
</html>