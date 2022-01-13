<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
<script>
	function phoneCheck() {
		var t_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;//전화번호 유효성 검사 정규식

		var Phone = document.getElementById("m_phone"); //전화번호

		/*휴대폰 유효성*/
		//공백 입력여부 검사
		if (Phone.value == '') {
			alert("전화번호를 입력해주세요.");
			return false;
		}

		//전화번호 유효성 검사
		if (!t_RegExp.test(Phone.value)) {
			alert("전화번호 형식이 올바르지 않습니다! 다시 입력해주세요.");
			return false;
		}

	}
</script>
</head>
<body>
	<div align="center">
	<h2>개인 정보 수정하기</h2>
	</div>
	<br>
	<table class="table" align="center">
	<c:if test="${ mvo == null }">
		<form name="memberModify" id="memberModify" action="/member/memberModify" method="POST" onsubmit="return phoneCheck()">
			<tr>
				<td><label id="memberModify">아이디</label></td>
				<td><input id="m_id" name="m_id" value="${memberVO.m_id }" readonly="true" /></td>
			</tr>
			<tr>
				<td><label id="memberModify">이름</label></td>
				<td><input id="m_name" name="m_name" value="${memberVO.m_name }" readonly="true" /></td>
			</tr>
			<tr>
				<td><label id="memberModify">핸드폰 번호</label></td>
				<td><input type="text" id="m_phone" name="m_phone" placeholder="(-)를 제외한 11자리 " /></td>
			</tr>
			<tr>
				<td><label id="memberModify">생년월일</label></td>
				<td><input id="m_birth" name="m_birth" value="${memberVO.m_birth }" readonly="true"/></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정하기" class="btn btn-success"/></td>
			</tr>
		</form>
	</c:if>
	</table>
</body>
</html>