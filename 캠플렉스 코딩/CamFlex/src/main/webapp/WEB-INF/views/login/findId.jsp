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
<title>아이디 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function find_id() {
		var n_RegExp = /^[가-힣a-zA-Z]{0,50}$/; //이름 특수문자 사용불가 정규식(한글,영문만 가능)
		var t_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;//전화번호 정규식

		var name = document.getElementById("m_name");//이름
		var phone = document.getElementById("m_phone");//전화번호

		/*===============이름, 전화번호 공백===============*/
		if (name.value == '' || phone.value == '') {
			alert("이름과 전화번호를 입력해주세요.")
			return false;
		}

		/*===============이름===============*/
		//이름 공백 검사
		if (name.value == '') {
			alret("이름을 입력해주세요.");
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
			alret("핸드폰 번호를 입력해주세요.");
			phone.focus();
			return false;
		}

		//전화번호 유효성 검사
		if (!t_RegExp.test(phone.value)) {
			alert(" 전화번호 형식이 올바르지 않습니다. 다시 입력해주세요.");
			phone.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<h2>아이디 찾기</h2>
	<c:if test="${mvo == null }">
		<form id="findId" name="findId" action="/login/findId" method="POST" onsubmit="return find_id()">
			<div class="form-group" style="width: 280px">
				<label id="find_id_info">이름</label>
				<input type="text" class="form-control" id="m_name" name="m_name" placeholder="이름" >
			</div>
			<div class="form-group" style="width: 280px">
				<label id="find_id_info">전화번호</label><input type="text" class="form-control" id="m_phone" name="m_phone" placeholder="전화번호">
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="아이디 찾기" />
			</div>
		</form>
	</c:if>
	<br>
	<c:if test="${mvo != null}">
		${mvo.m_name}님 아이디는 ${mvo.m_id} 입니다.
		<div>
			<a href="/login/login">로그인 페이지로 이동하기</a>
		</div>
	</c:if>
</body>
</html>