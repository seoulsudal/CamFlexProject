<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 예약 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
var r_number = $(this).parents("tr").attr("data-num");
	$("#r_number").val(r_number);
function confirmBtn(r_number){
	if(confirm("예약을 승인하시겠습니까?")){
		self.location = "/admin/reservation/confirmRsv?r_number=" + r_number;
		alert("승인되었습니다.");
	}
	else{
		self.location = "/admin/reservation/newReservation";
	}
}
function cancelBtn(r_number){

	if(confirm("예약을 취소시키겠습니까?")){
		self.location = "/admin/reservation/cancelRsv?r_number=" + r_number;
		alert("예약이 취소되었습니다.");
	}
	else{
	self.location = "/admin/reservation/newReservation";
	}
	
}
</script>
</head>
<body>

<h2 align="center">신규 예약 리스트</h2>
<div align="center">
	<form id="confirmRsv" action="newRsvList" method="get">
	<table class="table">
		<thead>
			<tr>
				<td align="center">예약번호</td>
				<td align="center">상품번호</td>
				<td align="center">아이디</td>
				<td align="center">금액</td>
				<td align="center">예약 신청일</td>
				<td align="center">예약 시작일</td>
				<td align="center">예약 종료일</td>
				<td align="center">예약 승인</td>
				<td align="center">예약 취소</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty newRsvList}">
					<tr>
						<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="rs" items="${newRsvList}">
						<tr data-num="${rs.r_number}">
							<td align="center">${rs.r_number}</td>
							<td align="center">${rs.p_number}</td>
							<td align="center">${rs.m_id}</td>
							<td align="center">${rs.r_price}</td>
							<td align="center"><fmt:formatDate value="${rs.r_apllicationDate}" pattern="yyyy/MM/dd" /></td>
							<td align="center"><fmt:formatDate value="${rs.r_startDate}" pattern="yyyy/MM/dd" /></td>
							<td align="center"><fmt:formatDate value="${rs.r_endDate}" pattern="yyyy/MM/dd" /></td>
							<td align="center"><button type="button" onclick="confirmBtn('${rs.r_number}')">예약승인</button></td>
							<td align="center"><button type="button" onclick="cancelBtn('${rs.r_number}')">예약취소</button></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
		
	</form>
	<!-- 페이징 네비게이션 -->
	<div>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/admin/reservation/newReservation${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</div>

</body>
</html>