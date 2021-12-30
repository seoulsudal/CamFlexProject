<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#replyBtn").click(function(){
		$("#i_detail").attr({
			"method":"get",
			"action":"/admin/inquiry/replyInquiry"
		});	
		$("#i_detail").submit();
	});
	$("#updateBtn").click(function(){
		$("#i_detail").attr({
			"method":"get",
			"action":"/admin/inquiry/updateReplyInquiry"
		});	
		$("#i_detail").submit();
	});
	
	$("#inquiryListBtn").click(function(){
		location.href="/admin/inquiry/inquiryList";
	});
});
</script>
</head>
<body>
<div align="center"><h2>문의사항 상세 페이지</h2></div>
	<form id="i_detail" name="i_detail" method = "post" >
		<input type="hidden" name="i_number" id="i_number" value="${detail.i_number}" />
		<input type="hidden" name="m_id" id="m_id" value="${detail.m_id}" />
	</form>
		<div align="center">
			<table class="table" border="1">
				<colgroup>
					<col width="15%" />
					<col width="85%" />
				</colgroup>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="form-control" name="m_id" id="m_id" value="${detail.m_id}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글 제목</td>
					<td><input type="text" class="form-control" name="i_title" id="i_title" value="${detail.i_title}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><textarea class="form-control" name="i_content" id="i_content" readonly="readonly">${detail.i_content}</textarea></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${detail.i_date}" /></td>
				</tr>
			</table>
		
	</div>
	<div align="right">
		<c:if test="${detail.parentNO eq '0'}">
			<input type="button" value="답글" id="replyBtn" class="btn btn-default">
		</c:if>
		<c:if test="${detail.parentNO ne '0'}">
			<input type="button" value="수정" id="updateBtn" class="btn btn-default">
		</c:if>
		<input type="button" value="목록" id="inquiryListBtn" class="btn btn-default">
	</div>
</body>
</html>