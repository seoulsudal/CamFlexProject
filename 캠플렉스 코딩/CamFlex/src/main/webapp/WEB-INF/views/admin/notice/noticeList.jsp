<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#insertFormBtn").click(function(){
		location.href = "/admin/notice/regNotice";
	});
	
	$(".goDetail").click(function(){
		var n_number = $(this).parents("tr").attr("data-num");
		$("#n_number").val(n_number);
		console.log("상품 번호 : " + n_number);
		
		$("#listForm").attr({
			"method":"get",
			"action":"/admin/notice/noticeDetail"
		});
		$("#listForm").submit();
	});
});
</script>
</head>
<body>
	<div><h3 align="center">공지사항 리스트</h3></div>
	
	<form name="listForm" id="listForm">
		<input type="hidden" name="n_number" id="n_number">
	</form>
	
	<div id="noticeList" align="center">
		<table class="table">
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col width="50%" />
				<col width="25%" />
			</colgroup>
			<thead>
				<tr>
					<td align="center">글번호</td>
					<td align="center">작성자</td>
					<td align="center">공지사항</td>
					<td align="center" data-value="n_date">작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty noticeList}">
						<c:forEach var="notice" items="${noticeList}" varStatus="status">
							<tr data-num="${notice.n_number}">
								<td align="center">${notice.n_number}</td>
								<td align="center">${notice.n_writer}</td>
								<td class="goDetail tal" align="center">${notice.n_title}</td>
								<td align="center"><fmt:formatDate value="${notice.n_date}" pattern="yyyy/MM/dd" /></td>
							</tr>
						</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" align="center">등록된 공지사항이 존재하지 않습니다.</td>
							</tr>
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
			<a href="/admin/notice/noticeList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
		<div align="right">
		<input type="button" value="등록" id="insertFormBtn" class="btn btn-default">
	</div>
	</div>
</body>
</html>