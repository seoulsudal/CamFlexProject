<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠플렉스 관리자 페이지</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

		<div align="center" id="list">
			<h2>관리자 페이지</h2>
		</div>
		<div align="center">
			<form>
				<table class="table">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<thead>
						<tr>
							<td align="center">전일 매출</td>
							<td align="center">신규 예약 대기</td>
							<td align="center">금일 방문 고객</td>
							<td align="center">신규 회원</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">${yesterday}원</td>
							<td align="center"><a href="/admin/reservation/newReservation">${newRsv}건</a></td>
							<td align="center"><a href="/admin/reservation/reservationList?searchType=t&keyword=">${visit}팀</a></td>
							<td align="center"><a href="/admin/member/memberList?searchType=d&keyword=">${todayMember}명</a></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

</body>
</html>