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
<title>예약 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
function chkSubmit(item, msg){
	if(item.val().replace(/\s/g,"") == ""){
		alert(msg + "입력해 주세요.");
		item.val("");
		item.focus();
		return false();
	}else{
		return true;
	}
}	
</script>
</head>
<body>
<h2 align="center">예약 리스트</h2>
<div>
<div align="center">
<form:form modelAttribute="pgrq" method="get" action="reservationList${pgrq.toUriStringByPage(1)}">
	<form:select path="searchType"  items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input path="keyword"/>
	<button id="searchBtn" class="btn btn-default">검색</button>
</form:form>
</div>
<div id="reservationList" align="center">
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
				<td align="center">예약 확정일</td>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty reservationList}">
					<tr>
						<td colspan="7" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="rs" items="${reservationList}">
						<tr>
							<td align="center">${rs.r_number}</td>
							<td align="center">${rs.p_number}</td>
							<td align="center">${rs.m_id}</td>
							<td align="center">${rs.r_price}</td>
							<td align="center"><fmt:formatDate value="${rs.r_apllicationDate}" pattern="yyyy/MM/dd" /></td>
							<td align="center">${rs.r_startDate}</td>
							<td align="center">${rs.r_endDate}</td>
							<td align="center"><fmt:formatDate value="${rs.r_updDate}" pattern="yyyy/MM/dd" /></td>
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
			<a href="/admin/reservation/reservationList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</div>
</div>
</body>
</html>