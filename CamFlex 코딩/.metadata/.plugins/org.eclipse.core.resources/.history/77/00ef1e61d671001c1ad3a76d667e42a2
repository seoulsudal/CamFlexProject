<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 인증 페이지</title>
</head>
<body>
	<h2>비밀번호 인증</h2>
	<c:if test="${mvo == null }">
		<form id="PwCheck" name="PwCheck" action="pwCheck" method="POST">
			<div>
				<label id="pwCheck_info">비밀번호</label> <input type="password"
					id="m_pw" name="m_pw" placeholder="비밀번호를 입력해주세요.">
			</div>

			<div>
				<input type="submit" value="인증하기"
					onClick="location.href='memberModifyForm'" />
			</div>
		</form>
	</c:if>
</body>
</html>