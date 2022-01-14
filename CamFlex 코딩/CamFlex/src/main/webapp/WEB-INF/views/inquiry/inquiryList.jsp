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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>

<script type="text/javascript">
$(function() {
	// 제목 클릭시
	$(".goDetail").click(function() {
		var i_number = $(this).parents("tr").attr("data-num");
		
		$("#i_number").val(i_number);
		
		console.log("글번호 : " + i_number);
		
		$("#detailForm").attr({
			"method":"get",
			"action":"/inquiry/inquiryDetail"
		});
		$("#detailForm").submit();
	});
	
	// 문의 작성 클릭 시
	$("#insertFormBtn").click(function() {
		location.href = "/inquiry/inquiryWrite";
	});
});
</script>

</head>
<body>
	<%-- 1:1 문의 페이지 이동을 위한 Form --%>
	<form name="detailForm" id="detailForm">
		<input type="hidden" name="i_number" id="i_number" value="${inquiry.i_number}">
		<input type="hidden" id="m_id" name="m_id" value="${id}">
	</form>
	
	<div align="center">
	<h2>1:1문의 리스트</h2>
	</div>
	<br>
	<div class="well" align="center">
	<table border="1" style="text-align: center; width: 90%;" class="table">
		<colgroup>
			<col width="15%">
			<col width="60%">
			<col width="25%">
		</colgroup>
		<thead>
			<tr>
				<td><font size="3px">번호</font></td>
				<td><font size="3px">제목</font></td>
				<td><font size="3px">작성일</font></td>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty inquiryList}">
				<tr>
					<td colspan="3" style="text-align: center;">등록된 문의 내역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${inquiryList}" var="inquiry">
					<tr data-num="${inquiry.i_number}">
						<td>${inquiry.i_number}</td>
						<td class="goDetail">${inquiry.i_title}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${inquiry.i_date}"/></td>						
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
	<br>
	<div align="center">
		<input type="button" value="문의 작성" id="insertFormBtn" class="btn">
	</div>
	<!-- 페이징 네비게이션 -->
	<div align="center">
	<br>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/inquiry/inquiryList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</body>