<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".goDetail").click(function(){
		var i_number = $(this).parents("tr").attr("data-num");
		$("#i_number").val(i_number);
		console.log("글 번호 : " + i_number);
		
		$("#listForm").attr({
			"method":"get",
			"action":"/admin/inquiry/inquiryDetail"
		});
		$("#listForm").submit();
	});
});
</script>
</head>
<body>
<div><h3 align="center">문의사항 리스트</h3></div>
	
	<form name="listForm" id="listForm">
		<input type="hidden" name="i_number" id="i_number">
	</form>
	
	<div id="inquiryList" align="center">
		<table class="table">
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col width="15%" />
				<col width="40%" />
				<col width="20" />
			</colgroup>
			<thead>
				<tr>
					<td align="center">글번호</td>
					<td align="center">문의항목</td>
					<td align="center">아이디</td>
					<td align="center">제목</td>
					<td align="center">작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty inquiryList}">
						<tr>
								<td colspan="5" align="center">등록된 공지사항이 존재하지 않습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" items="${inquiryList}">
							<tr data-num="${i.i_number}">
								<td align="center">${i.i_number}</td>
								<td align="center">${i.i_kinds}</td>
								<td align="center"><c:if test="${i.parentNO eq '0'}">${i.m_id}</c:if>
													<c:if test="${i.parentNO ne '0'}">관리자</c:if>
								</td>
								<td class="goDetail tal" align="center">${i.i_title}</td>
								<td align="center"><fmt:formatDate value="${i.i_date}" pattern="yyyy/MM/dd" /></td>
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
			<a href="/admin/inquiry/inquiryList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
	</div>
</body>
</html>