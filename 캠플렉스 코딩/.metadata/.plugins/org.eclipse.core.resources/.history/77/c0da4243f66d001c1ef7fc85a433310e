<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#memberInsert").click(function() {
			$("#insertMember").attr({
				"method":"POST",
				"action":"/member/join"
			});
			$("#insertMember").submit();
		})
	})
</script>
</head>
<body>
	<h2>회원가입</h2>
	
	<form name="insertMember" id="insertMember">
		<!-- 아이디 -->
		<div>
			<label id="userInfo">아이디</label>
			<input type="text" id="m_id" name="m_id" placeholder="email형식으로 입력" />
		</div>
		<p></p>

		<!-- 비밀번호 -->
		<div>
			<label id="userInfo">비밀번호</label>
			<input type="password" id="m_pw" name="m_pw" placeholder="영문/숫자 8~20자 (특수문자x)" maxlength="20"/>
		</div>
		<p></p>

		<!-- 비밀번호 재확인 -->
		<!-- <div>
			<label id="userInfo">비밀번호 재확인</label>
			<input type="password" id="m_Pw_check" name="m_Pw_check" placeholder="위 비밀번호와 동일하게 입력" maxlength="20"/>
		</div>
		<p></p> -->

		<!-- 이름 -->
		<div>
			<label id="userInfo">이름</label>
			<input type="text" id="m_name" name="m_name" placeholder="특수문자 or 숫자x 50자 미만" maxlength="50"/>
		</div>
		<p></p>

		<!-- 생년월일 -->
		<div>
			<label id="userInfo">생년월일</label>
			<input type="text" id="m_birth" name="m_birth" placeholder="생년월일 숫자 8자리" maxlength="8"/>
		</div>
		<p></p>

		<!-- 전화번호 -->
		<div>
			<label id="userInfo">전화번호</label>
			<input type="text" id="m_phone" name="m_phone" placeholder="(-)를 제외한 11자" maxlength="11"/>
		</div>
		<p></p>

		<div>
			<input type="button" id="memberInsert" value="회원가입" />
		</div>
	</form>
</body>
</html>