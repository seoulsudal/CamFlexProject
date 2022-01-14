<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
	<div class="col-sm-6">
		<div class="panel panel-default" align="center">
			<div>
				<h3>예약 달력</h3>
			</div>
			<div class="panel-body">
				<table id="table1">
					<tr>
						<!-- 이전달 버튼 만들기 -->
						<th><input type="button" value="이전 달" disabled /></th>
						<!-- 제목 만들기 -->
						<th id="title" colspan="5">${year}년${month}월</th>
						<!-- 다음달 버튼 만들기 -->
						<th><input type="button" value="다음 달" onclick="monthNext(${yearNext}, ${monthNext})" />
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
						<!-- 1일 전까지 빈칸 띄워주기 -->
						<c:forEach var="i" begin="1" end="${monthStartFirst%7}">
							<th></th>
						</c:forEach>
						<!-- 오늘까지 띄워주기 -->
						<c:forEach var="i" begin="1" end="${today}">
							<c:choose>
								<c:when test="${(i+monthStartFirst-1)%7==0}">
									<th class="lastDays">${i }</th>
								</c:when>
								<c:when test="${(i+monthStartFirst-1)%7==6}">
									<th class="lastDays">${i}</th>
								</c:when>
								<c:otherwise>
									<th class="lastDays">${i}</th>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${(i+monthStartFirst-1)%7==6 && i!=monthEndFirst}">
									<% out.println("</tr><tr>"); %>
								</c:when>
							</c:choose>
						</c:forEach>

						<!-- 오늘 이후로 날짜 띄워주기 -->
						<c:forEach var="i" begin="${today+1}" end="${monthEndFirst}">
							<c:choose>
								<c:when test="${(i+monthStartFirst-1)%7==0 }">
									<td class="sun" id="date${i}" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
								</c:when>
								<c:when test="${(i+monthStartFirst-1)%7==6 }">
									<td class="sat" id="date${i}" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
								</c:when>
								<c:otherwise>
									<td class="etc" id="date${i}" onClick="dateClick(${i}, ${year}, ${month})">${i}</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${(i+monthStartFirst-1)%7==6 && i!=monthEndFirst}">
									<% out.println("</tr><tr>"); %>
								</c:when>
							</c:choose>
						</c:forEach>
					</tr>
				</table>

				<table id="table2">
					<tr>
						<!-- 이전달 버튼 만들기 -->
						<th><input type="button" value="이전 달" onclick="monthPrevious(${year}, ${month })" />
						</th>
						<!-- 제목 만들기 -->
						<th id="title" colspan="5" align="center">${yearNext}년${monthNext }월</th>
						<!-- 다음달 버튼 만들기 -->
						<th><input type="button" value="다음 달" disabled />
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
									<td class="sun" id="date${i+32}" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
								</c:when>
								<c:when test="${(i+monthStartSecond-1)%7==6}">
									<td class="sat" id="date${i+32}" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
								</c:when>
								<c:otherwise>
									<td class="etc" id="date${i+32}" onClick="dateClick(${i+32}, ${yearNext}, ${monthNext})">${i}</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${(i+monthStartSecond-1)%7==6 && i!=monthEndSecond}">
									<% out.println("</tr><tr>"); %>
								</c:when>
							</c:choose>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>

	</div>
	<div class="col-sm-6">
		<div align="center">
			<h2>객실 정보</h2>
			<br>
			<div align="center" class="well">
				<div style="font-size: 10">
					방 이름 : ${detail.p_name}<br>
				</div>
				1박 당 가격 : <fmt:formatNumber value="${detail.p_price}" pattern="#,###원"/><br>
				<font size="1">
				*주의사항* 예약리스트를 확인 후 예약신청을 해주세요.<br>
				예약신청 시 관리자가 다른 예약과 날짜 확인 후 예약확정으로 변경해드립니다.<br>
				다른 예약과 날짜가 겹칠경우 예약이 취소 될 수 있습니다.
				</font>
			</div>
			<br>
			<h2>객실 예약 리스트</h2>
			<div align="center" class="well">
				<c:choose>
					<c:when test="${empty reservationList}">
						<div class="well">
							<font size="3">해당 상품은 현재 예약 없습니다.</font>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${reservationList}" var="reservation">
						<div>
							예약번호 : ${reservation.r_number}, <br>
							예약 시작일 : ${reservation.r_startDate}, <br>
							예약 종료일 : ${reservation.r_endDate}
						</div>
							<br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<br>
		<div align="center">
			<button type="button" class="btn btn-success" id="reservation" disabled style="font-size: 20px; height: 75px; width: 150px;">예약하러 가기</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-success" id="BtnProductList" style="font-size: 20px; height: 75px; width: 150px;">목록</button>
			<%-- 예약 동의 페이지 이동을 위한 Form --%>
			<form id="dateSend" name="dateSend">				
				<input type="hidden" id="r_startDate" name="r_startDate" value="${year}-${month}-" />
				<input type="hidden" id="r_endDate" name="r_endDate" value="${year}-${month}-" />
				<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}" />
				<input type="hidden" name="p_name" id="p_name" value="${detail.p_name}" />
				<input type="hidden" name="p_price" id="p_price" value="${detail.p_price}" />
				<input type="hidden" id="m_id" name="m_id" value="${id}">
			</form>
		</div>
	</div>

</body>
</html>