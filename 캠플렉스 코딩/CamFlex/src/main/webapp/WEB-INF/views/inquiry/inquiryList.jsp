<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(function() {
	// 문의 작성 클릭 시
	$("#insertFormBtn").click(function() {
		location.href = "/inquiry/inquiryWrite";
	});
});
</script>

</head>
<body>
	<form name="detailForm" id="detailForm">
		<input type="hidden" name="i_number" id="i_number">
		<input type="hidden" id="m_id" name="m_id" value="${id}">
	</form>
	
	<table border="1" style="text-align: center;">
		<colgroup>
			<col width="15%">
			<col width="65%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty inquiryList}">
				<tr>
					<td colspan="3">등록된 문의 내역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${inquiryList}" var="inquiry">
					<tr>
						<td>${inquiry.i_number}</td>
						<td><a href="/inquiry/inquiryDetails?i_number=${inquiry.i_number}">${inquiry.i_title}</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${inquiry.i_date}"/></td>						
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<div>
		<input type="button" value="문의 작성" id="insertFormBtn" class="btn">
	</div>
</body>