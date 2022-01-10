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
		var p_RegExp = /^[a-zA-Z0-9]{8,20}$/; //비밀번호 유효성 검사 정규식

		var Pw = document.getElementById("m_pw"); //비밀번호
		var RePw = document.getElementById("m_pw_chk"); //비밀번호 재확인
		var Phone = document.getElementById("m_phone"); //전화번호

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

		// 비밀번호 재확인 공백 입력여부 
		if (RePw.value == '') {
			alert("비밀번호 재확인을 입력해주세요.");
			return false;
		}

		//비밀번호 재확인 
		if (Pw.value != RePw.value) {
			alert("비밀번호 재입력이 틀립니다! 다시 입력해주세요.");
			return false;
		}

		//전화번 공백 입력여부
		if (Phone.value == '') {
			alert("전화번호를 입력해주세요.");
			return false;
		}

		// 전화번호 유효성 
		if (!t_RegExp.test(Phone.value)) {
			alert("전화번호 형식이 올바르지 않습니다! 다시 입력해주세요.");
			return false;
		}

	}
</script>
</head>
<body>
	<h2>개인 정보 수정하기</h2>

	<c:if test="${ mvo == null }">
		<form name="MemberModify" id="MemberModify"
			action="/member/MemberModify" method="POST"
			onsubmit="return phoneCheck()">
			<div>
				<label id="MemberModify">아이디</label> <input id="m_id" name="m_id"
					value="${memberVO.m_id }" readonly="true" />
			</div>

			<div>
				<label id="MemberModify">비밀번호</label> <input type="password"
					id="m_pw" name="m_pw" placeholder="8~20자 내로 입력" />
			</div>
			<div>
				<label id="MemberModify">비밀번호 재확인</label> <input type="password"
					id="m_pw_chk" name="m_pw_chk" placeholder="위와 같이 동일하게 입력" />
			</div>


			<div>
				<label id="MemberModify">이름</label> <input id="m_name" name="m_name"
					value="${memberVO.m_name }" readonly="true" />
			</div>


			<div>
				<label id="MemberModify">핸드폰 번호</label> <input type="text"
					id="m_phone" name="m_phone" placeholder="(-)를 제외한 11자리 " />
			</div>


			<div>
				<label id="MemberModify">생년월일</label> <input type="text"
					id="m_birth" name="m_birth" value="${memberVO.m_birth }"
					pattern="yyyy/MM/dd" readonly="true" />
			</div>

			<div>
				<input type="submit" value="수정하기" />
			</div>
		</form>
	</c:if>
</body>
</html>