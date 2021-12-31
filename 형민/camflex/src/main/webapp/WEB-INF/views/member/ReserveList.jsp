<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="reservationList" align="center">
		<table class="table">
			<thead>
				<tr>
					<th>예약번호</th>
					<th>상품명</th>
					<th>예약일</th>
					<th>예약 종료일</th>
					<th>렌탈 장비</th>
					<th>총 금액</th>
					<th>결제 방법</th>
					<th>취소 현황</th>
				</tr>
			</thead>
			<tbody id="list">
				<c:choose>
					<c:when test="${empty ReserveList}">
						<tr>
							<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="rl" items="${ReserveList}">
							<tr>
								<td>${rl.r_number }</td>
								<td><c:if test="${rl.p_number eq '1'}">오토A</c:if> <c:if
										test="${rl.p_number eq '41'}">오토B</c:if> <c:if
										test="${rl.p_number eq '42'}">글램핑A</c:if> <c:if
										test="${rl.p_number eq '43'}">글램핑B</c:if> <c:if
										test="${rl.p_number eq '44'}">글램핑C</c:if> <c:if
										test="${rl.p_number eq '45'}">글램핑D</c:if> <c:if
										test="${rl.p_number eq '46'}">차박A</c:if> <c:if
										test="${rl.p_number eq '47'}">차박B</c:if></td>
								
								<td><fmt:formatDate value="${rl.r_startDate}"
										pattern="yyyy/MM/dd" /></td>
								<td><fmt:formatDate value="${rl.r_endDate}"
										pattern="yyyy/MM/dd" /></td>
								<td>${rl.r_price}</td>
								<td>현금</td>
								<td><input type="button" value="예약 취소" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

	</div>
	</div>
</body>
</html>