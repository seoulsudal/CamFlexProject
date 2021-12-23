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
<div>
	<div><h3 align="center">공지사항 리스트</h3></div>
	
	<form name="listForm" id="listForm">
		<input type="hidden" name="n_number" id="n_number">
	</form>
	
	<div id="noticeList" align="center">
		<table border="1">
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col width="50%" />
				<col width="25%" />
			</colgroup>
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>공지사항</th>
					<th data-value="n_date">작성일</th>
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
	</div>
	<div>
		<input type="button" value="등록" id="insertFormBtn">
	</div>
</div>
</body>
</html>