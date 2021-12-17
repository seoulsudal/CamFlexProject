<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 예약</title>
<link rel="stylesheet" type="text/css" href="/resources/css/reservation/reserveCalendar.css">
<script src="/resources/js/reservation/reserveCalendar.js"></script>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/include/js/common.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
  	$(function() {
		$("#btnReservation").click(function() {
			$("#reservationForm").attr({
				"method":"POST",
				"action":"/reservation/reservationAgreePage"
			});
			$("#reservationForm").submit();
		});
	});
  	
</script>
</head>
<body>
	<div class="col-sm-6">
		<form id="p_detail" name="p_detail" method = "post">
			<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}"/>
			<input type="hidden" name="p_name" id="p_name" value="${detail.p_name}"/>
			<input type="hidden" name="p_price" id="p_price" value="${detail.p_price}"/>
		</form>
		<form id="reservationForm" name="reservationForm">
			<div class="panel panel-default" align="center">
				<div>
					<h3>예약 달력</h3>
				</div>
				<div class="panel-body">
					<table id="table1">
		<tr>
			<!-- 이전달 버튼 만들기 -->
			<th>
				<input type="button" value="이전 달" disabled/>
			</th>
			<!-- 제목 만들기 -->
			<th id="title" colspan="5">${year }년 ${month }월</th>
			<!-- 다음달 버튼 만들기 -->
			<th>
				<input type="button" value="다음 달" onclick="monthNext(${yearNext}, ${monthNext})" />
			<!-- onclick="monthChange(${year}, ${month+1})" /> -->
			</th>
		</tr>
		<tr>
			<th class="sunday">일</th>
			<th class="etcday">월</th>
			<th class="etcday">화</th>
			<th class="etcday">수</th>
			<th class="etcday">목</th>
			<th class="etcday">금</th>
			<th class="saturday">토</th>
		</tr>
		<tr>
			<c:forEach var="i" begin="1" end="${monthStartFirst%7 }">
				<th></th>
			</c:forEach>
			<c:forEach var="i" begin="1" end="${monthEndFirst }">
				<c:choose>
					<c:when test="${(i+monthStartFirst-1)%7==0 }">
						<td class="sun" id="date${i }" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
					</c:when>
					<c:when test="${(i+monthStartFirst-1)%7==6 }">
						<td class="sat" id="date${i }" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
					</c:when>
					<c:otherwise>
						<td class="etc" id="date${i }" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${(i+monthStartFirst-1)%7==6 && i!=monthEndFirst }">
						<%
							out.println("</tr><tr>");
						%>
					</c:when>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
	
	<table id="table2">
		<tr>
			<!-- 이전달 버튼 만들기 -->
			<th>
				<input type="button" value="이전 달" onclick="monthPrevious(${year}, ${month })" />
				<!-- onclick="location.href='?year=${year}&month=${month-1}'"  -->
			</th>
			<!-- 제목 만들기 -->
			<th id="title" colspan="5">${yearNext}년 ${monthNext }월</th>
			<!-- 다음달 버튼 만들기 -->
			<th>
				<input type="button" value="다음 달" disabled/>
			<!-- onclick="monthChange(${year}, ${month+1})" /> -->
			</th>
		</tr>
		<tr>
			<th class="sunday">일</th>
			<th class="etcday">월</th>
			<th class="etcday">화</th>
			<th class="etcday">수</th>
			<th class="etcday">목</th>
			<th class="etcday">금</th>
			<th class="saturday">토</th>
		</tr>
		<tr>
			<c:forEach var="i" begin="1" end="${monthStartSecond%7}">
				<th></th>
			</c:forEach>
			<c:forEach var="i" begin="1" end="${monthEndSecond}">
				<c:choose>
					<c:when test="${(i+monthStartSecond-1)%7==0}">
						<td class="sun" id="date${i+32 }" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
					</c:when>
					<c:when test="${(i+monthStartSecond-1)%7==6 }">
						<td class="sat" id="date${i+32 }" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
					</c:when>
					<c:otherwise>
						<td class="etc" id="date${i+32 }" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${(i+monthStartSecond-1)%7==6 && i!=monthEndSecond }">
						<%
							out.println("</tr><tr>");
						%>
					</c:when>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
				</div>
			</div>
		</form>
	</div>
    <div class="col-sm-6">
    	<div align="center">
    		<h2>객실 정보</h2>
    		<br>
    		<div align="center" class="well">
    			<div style="font-size: 10">방 이름 : ${detail.p_name}<br><br></div>
    			<p>1박 당 가격 : ${detail.p_price} 원</p>
    		</div>
    	</div>
    	<br>
    	<br>
    	<br>
    	<div align="center">
    		<input type="button" value="예약 하기" style="font-size: 20px; height: 75px; width: 200px;" id="btnReservation" name="btnReservation" class="btn btn-success">
    	</div>
    </div>
	
</body>
</html>