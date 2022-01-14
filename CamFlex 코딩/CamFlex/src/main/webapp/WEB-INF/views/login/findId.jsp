<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디와 비밀번호 찾기</title>
<script type="text/javascript">
	function find_id_Check() {
		var n_RegExp = /^[가-힣a-zA-Z]{0,50}$/; //이름 특수문자 사용불가 정규식(한글,영문만 가능)
		var t_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;//전화번호 정규식

		var name = document.getElementById("m_name");//이름
		var phone = document.getElementById("m_phone");//전화번호


		/*===============이름===============*/
		//이름 공백 검사
		if (name.value == '') {
			alert("이름을 입력해주세요.");
			name.focus();
			return false;
		}

		//이름 유효성 검사
		if (!n_RegExp.test(name.value)) {
			alert("이름에 특수문자,숫자는 입력할수 없습니다. 다시 입력해주세요.");
			name.focus();
			return false;
		}

		/*===============전화번호===============*/
		//전화번호 공백 검사
		if (phone.value == '') {
			alert("핸드폰 번호를 입력해주세요.");
			phone.focus();
			return false;
		}

		//전화번호 유효성 검사
		if (!t_RegExp.test(phone.value)) {
			alert("전화번호 형식이 올바르지 않습니다. 다시 입력해주세요.");
			phone.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<h2>아이디 찾기</h2>
	<c:if test="${mvo == null }">
		<form id="findId" name="findId" action="findId" method="POST"
			onsubmit="return find_id_Check()">
			<div style="width: 350px">
				<input type="text" id="m_name" name="m_name"
					style="width: 305px; height: 35px;" placeholder="이름">
			</div>
			<p></p>
			<div style="width: 350px">
				<input type="text" id="m_phone" name="m_phone"
					style="width: 305px; height: 35px;" placeholder="전화번호">
			</div>
			<p></p>
			<div style="width: 350px">
				<input type="submit" value="아이디 찾기"
					style="width: 305px; height: 35px;" class="btn btn-success" />
			</div>
		</form>
	</c:if>

	<c:if test="${mvo != null }">
		${mvo.m_name}님 아이디는 ${mvo.m_id} 입니다.
	</c:if>
</body>
</html>