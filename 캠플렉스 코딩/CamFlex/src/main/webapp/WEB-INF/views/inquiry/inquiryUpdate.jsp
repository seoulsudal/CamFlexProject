<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(function() {
	// 수정 버튼 클릭시
	$("#btnInquiryUpdate").click(function() {
		// 입력값 체크
		$("#data").attr({
			"method":"POST",
			"action":"/inquiry/inquiryUpdate"
		});
		$("#data").submit();
	});		

	// 목록 버튼 클릭시
	$("#btnInquiryList").click(function() {
		location.href = "/inquiry/inquiryList";
	});
});
</script>

</head>
<body>
	<h3>문의글 수정</h3>
	<form name="data" id="data">
		<input type="hidden" name="m_id" id="m_id" value="${id}">
		<input type="hidden" name="i_number" id="i_number" value="${updateData.i_number}">
	
	
	<table border="1">
		<colgroup>
				<col width="17%">
				<col width="83%">
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" name="i_title" id="i_title" value="${updateData.i_title}"></td>
			</tr>
			<tr>
				<td>문의 항목</td>
				<td><input type="text" name="i_kinds" id="i_kinds" value="${updateData.i_kinds}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="i_content" name="i_content">${updateData.i_content}</textarea></td>
			</tr>
	</table>
	</form>
	<br>
	<div>
		<input type="button" value="수정" id="btnInquiryUpdate" class="btn">
		<input type="button" value="목록" id="btnInquiryList" class="btn">
	</div>
</body>
</html>