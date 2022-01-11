<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
</head>
<body>
	<div align="center">
		<h2>공지사항 리스트</h2>
	</div>
	<br>
	<%-- 상세 페이지 이동을 위한 FORM --%>
	<form name="detailForm" id="detailForm">
		<input type="hidden" name="n_number" id="n_number">
		<input type="hidden" name="m_id" id="m_id" value="${id}">
	</form>
	<div class="well" align="center">
	<table border="1" class="table" style="text-align: center;">
		<colgroup>
			<col width="15%" />
			<col width="52%" />
			<col width="18%" />
			<col width="15%" />
		</colgroup>
		<thead>
			<tr>
				<td align="center"><font size="5">글 번호</font></td>
				<td align="center"><font size="5">글 제목</font></td>
				<td align="center"><font size="5">작성일</font></td>
				<td align="center"><font size="5">작성자</font></td>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty noticeList}">
				<tr>
					<td colspan="4"><font size="15">등록된 공지사항이 없습니다.</font></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${noticeList}" var="notice">
					<tr align="center">
						<td align="center">${notice.n_number}</td>
						<td><a href="/notice/noticeDetail?n_number=${notice.n_number}">${notice.n_title}</a></td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.n_date}"/></td>
						<td align="center">${notice.n_writer}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
	<!-- 페이징 네비게이션 -->
	<div align="center">
	<br>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/notice/noticeList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</body>
</html>