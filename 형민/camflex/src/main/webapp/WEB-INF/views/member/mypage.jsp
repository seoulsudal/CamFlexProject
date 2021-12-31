<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 임시로 불러오는 마이페이지 -->
	<input type="text" value="${m_id}">
	<input type="button" value="내 정보" id="memberDate" name="memberDate"
		onclick="location.href='/member/MemberDate.do'" />
	<input type="button" value="내 예약정보" id="ReserveList" name="ReserveList"
		onclick="location.href='/member/ReserveList.do'" />
	<input type="button" value="내 예약 취소 내역 확인" id="CancelList"
		name="CancelList" onclick="location.href='/member/CancelList'" />
	<input type="button" value="1:1 문의" id="m_inquiryWrite"
		name="m_inquiryWrite" onclick="location.href='/member/m_inquiryWrite'" />
	<input type="button" value="계정 비활성화" id="memberDate" name="memberDate"
		onclick="location.href=''" />

</body>
</html>