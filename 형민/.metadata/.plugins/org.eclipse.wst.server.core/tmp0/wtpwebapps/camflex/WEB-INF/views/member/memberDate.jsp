<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>
<body>
	<input type="hidden" id="m_id" name="m_id" value="${id}">
	<div align="center">
	<h2>${memberVO.m_id}님의 정보</h2>
	<table class="table">
			<tr>
				<td><div>아이디</div></td>
				<td><div><input id="m_id" name="m_id" value="${memberVO.m_id}" readonly="true"/></div></td>
			</tr>
			<!-- <tr>
				<td><div>비밀번호</div></td>
				<td><div><input id="m_id" name="m_pw"  readonly="true" /></div></td>
			</tr>-->
			<tr>
				<td><div>이름</div></td>
				<td><div><input id="m_name" name="m_pw" value="${memberVO.m_name}" readonly="true"/></div></td>
			</tr>
			<tr>
				<td><div>핸드폰 번호</div></td>
				<td><div><input id="m_phone" name="m_phone" value="${memberVO.m_phone}" readonly="true"/></div></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input id="m_birth" name="m_birth" value="${memberVO.m_birth }" readonly="readonly"></td>
			</tr>
	</table>
	<input type="button" id="memberModifyForm_btn" name="memberModifyForm_btn" value="수정하기" onclick="location.href='pwCheck'" class="btn btn-success">
	</div>
</body>
</html>