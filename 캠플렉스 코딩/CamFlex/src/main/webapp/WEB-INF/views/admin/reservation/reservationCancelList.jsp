<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 취소 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2 align="center">예약 취소 리스트</h2>
<div id="reservationList" align="center">
	<table class="table">
		<thead>
			<tr>
				<td align="center">예약번호</td>
				<td align="center">상품번호</td>
				<td align="center">아이디</td>
				<td align="center">금액</td>
				<td align="center">예약 시작일</td>
				<td align="center">예약 종료일</td>
				<td align="center">예약 확정일</td>
				<td align="center">취소 사유</td>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty cancelList}">
					<tr>
						<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="rs" items="${cancelList}">
						<tr>
							<td align="center">${rs.r_number}</td>
							<td align="center">${rs.p_number}</td>
							<td align="center">${rs.m_id}</td>
							<td align="center">${rs.r_price}</td>
							<td align="center">${rs.r_startDate}</td>
							<td align="center">${rs.r_endDate}</td>
							<td align="center"><fmt:formatDate value="${rs.r_updDate}" pattern="yyyy/MM/dd" /></td>
							<td align="center">${rs.r_cancel}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
		<!-- 페이징 네비게이션 -->
	<div>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/admin/reservation/reservationCancelList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</div>
</body>
</html>