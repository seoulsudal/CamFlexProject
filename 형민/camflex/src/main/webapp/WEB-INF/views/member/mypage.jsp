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
	${m_id}
	
	<input type="button" value="내 정보" id="memberDate" name="memberDate" onclick="location.href='/member/MemberDate'" />
	<input type="button" value="내 예약정보" id="ReserveList" name="ReserveList" onclick="location.href='/member/ReserveList'" />

</body>
</html>