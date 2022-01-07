<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 예약 정보</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		//예약 취소 클릭 (취소 페이지로 이동)
		$(".reserveCancel").click(function() {

			var r_number = $(this).parents("tr").attr("data-num1");
			var r_price = $(this).parents("tr").attr("data-num2");
			var r_startDate = $(this).parents("tr").attr("data-num3");

			$("#r_number").val(r_number);
			$("#r_price").val(r_price);
			$("#r_startDate").val(r_startDate);

			console.log("예약번호 : " + r_number);
			console.log("예약금액 : " + r_price);
			console.log("예약날짜 : " + r_startDate);

			$("#reserveListDetail").attr({
				"method" : "get",
				"action" : "/member/ReserveCancel"
			});
			$("#reserveListDetail").submit();
		});
	});
</script>
</head>
<body>
	<form name="reserveListDetail" id="reserveListDetail">
		<input type="hidden" id="m_id" name="m_id" value="${list.m_id}">
		<input type="hidden" id="r_number" name="r_number"
			value="${list.r_number }"> <input type="hidden" id="r_price"
			name="r_price" value="${list.r_price }"> <input type="hidden"
			id="r_startDate" name="r_startDate" value="${list.r_startDate}">

	</form>

	<h2>내 예약 정보</h2>
	<table>
		<thead>
			<tr>
				<th>예약번호</th>
				<th>상품명</th>
				<th>예약일</th>
				<th>예약 종료일</th>
				<th>총 금액</th>
				<th>결제 방법</th>
				<th>취소 현황</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty reserveList}">
					<tr>
						<td colspan="7">예약이 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${reserveList}">
						<tr data-num1="${list.r_number}" data-num2="${list.r_price }"
							data-num3="${list.r_startDate}">

							<td>${list.r_number}</td>
							<td><c:if test="${list.p_number eq '1' }">오토A</c:if> <c:if
									test="${list.p_number eq '41' }">오토B</c:if> <c:if
									test="${list.p_number eq '42' }">글램핑A</c:if> <c:if
									test="${list.p_number eq '43' }">글램핑B</c:if> <c:if
									test="${list.p_number eq '44' }">글램핑C</c:if> <c:if
									test="${list.p_number eq '45' }">글램핑D</c:if> <c:if
									test="${list.p_number eq '46' }">차박A</c:if> <c:if
									test="${list.p_number eq '47' }">차박B</c:if>
							<td><fmt:formatDate value="${list.r_startDate }"
									pattern="yyyy/MM/dd" /></td>
							<td><fmt:formatDate value="${list.r_endDate }"
									pattern="yyyy/MM/dd" /></td>
							<td>${list.r_price }</td>
							<td>현금</td>

							<td><input type="button" class="reserveCancel"
								id="reserveCancel" name="btncancel" value="예약 취소" /></td>
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
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}"
			var="idx">
			<a href="/member/ReserveList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>

</body>
</html>