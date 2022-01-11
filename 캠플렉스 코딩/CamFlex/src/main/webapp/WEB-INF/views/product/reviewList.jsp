<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 리스트</title>
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
	<br>
	<h3>리뷰 리스트</h3>
	</div>
	<br>
	<div class="well" align="center">
	<table border="1" style="text-align: center; width: 90%;" class="table">
		<colgroup>
			<col width="8%">
			<col width="22%">
			<col width="50%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<td><font size="3px">번호</font></td>
				<td><font size="3px">아이디</font></td>
				<td><font size="3px">내용</font></td>
				<td><font size="3px">작성일</font></td>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty reviewList}">
				<tr>
					<td colspan="4">등록된 댓글 내역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${reviewList}" var="review">
					<tr>
						<td>${review.rv_number}</td>
						<td>${review.m_id}</td>
						<td>${review.rv_content}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${review.rv_date}"/></td>						
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
	<br>
</body>