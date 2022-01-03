<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난 예약 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function() {
	// 후기 작성 클릭 시
	$(".btnReviewInsert").click(function() {
		var p_number = $(this).parents("tr").attr("data-num1");
		var r_number = $(this).parents("tr").attr("data-num2");
		var rv_number = $(this).parents("tr").attr("data-num3");
		
		$("#p_number").val(p_number);
		$("#r_number").val(r_number);
		$("#rv_number").val(rv_number);
		
		console.log("상품 번호 : " + p_number);
		console.log("예약 번호 : " + r_number);
		console.log("후기 번호 : " + rv_number);
		
		$("#detailForm").attr({
			"method":"get",
			"action":"/review/reviewInsert"
		});
		$("#detailForm").submit();
	});
});
</script>
</head>
<body>
<h2 align="center">지난 예약 리스트</h2>
<form name="detailForm" id="detailForm">
		<input type="text" name="p_number" id="p_number" value="${past.p_number}">
		<input type="text" id="m_id" name="m_id" value="${id}">
		<input type="text" id="r_number" name="r_number" value="${past.r_number}">
		<input type="text" id="rv_number" name="rv_number" value="${past.rv_number}">
	</form>
<div align="center">
	<table class="table">
		<thead>
			<tr>
				<td align="center">예약번호</td>
				<td align="center">상품명</td>
				<td align="center">금액</td>
				<td align="center">예약 시작일</td>
				<td align="center">예약 종료일</td>
				<td align="center">후기</td>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty pastList}">
					<tr>
						<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="past" items="${pastList}">
						<tr data-num1="${past.p_number}" data-num2="${past.r_number}" data-num3="${past.rv_number}">
							<td align="center">${past.r_number}</td>
							<td align="center"><c:if test="${past.p_number eq '1'}">오토A</c:if>
								<c:if test="${past.p_number eq '41'}">오토B</c:if>
								<c:if test="${past.p_number eq '42'}">글램핑A</c:if>
								<c:if test="${past.p_number eq '43'}">글램핑B</c:if>
								<c:if test="${past.p_number eq '44'}">글램핑C</c:if>
								<c:if test="${past.p_number eq '45'}">글램핑D</c:if>
								<c:if test="${past.p_number eq '46'}">차박A</c:if>
								<c:if test="${past.p_number eq '47'}">차박B</c:if>
							</td>
							<td align="center">${past.r_price}</td>
							<td align="center">${past.r_startDate}</td>
							<td align="center">${past.r_endDate}</td>
							<td align="center">
							<input type="text" id="rv_number" name="rv_number" value="${past.rv_number}">
							<input type="button" class="btnReviewInsert" name="btnReviewInsert" value="후기 작성">										
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<!-- 페이징 네비게이션 -->
	<div align="center">
	<br>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/member/cancelList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
	</div>
</body>
</html>