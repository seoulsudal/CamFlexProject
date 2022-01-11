<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 작성</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(function() {
		// 작성 버튼 클릭시
		$("#btnInquiryWrite").click(function() {
			// 입력값 체크
			if(!chkSubmit($('#i_title'), "제목을")) return; 
			else if(!chkSubmit($('#i_kinds'), "항목을")) return;
			else if(!chkSubmit($('#i_content'), "내용을")) return;
			else{
			$("#writeForm").attr({
				"method":"POST",
				"action":"/inquiry/inquiryWrite"
			});
			$("#writeForm").submit();
			}
		});
	
		// 목록 버튼 클릭시
		$("#btnInquiryList").click(function() {
			location.href = "/inquiry/inquiryList";
		});
	});
</script>

</head>
<body>
	<div align="center">
		<h2>문의글 작성</h2>
	</div>
	<br>
	<div class="well" align="center">
	<form id="writeForm" name="writeForm">
		<input type="hidden" name="m_id" id="m_id" value="${id}">
		<table style="text-align: center; width: 90%;" class="table">
			<colgroup>
				<col width="17%">
				<col width="83%">
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" name="i_title" id="i_title" style="width: 90%"><p></p></td>				
			</tr>
			<tr>
				<td>문의 항목</td>
				<td>
					<select id="i_kinds" name="i_kinds" style="width: 90%">
						<option value="예약">예약관련</option>
						<option value="시설">시설관련</option>
						<option value="기타">기타관련</option>
					</select>
				<p></p></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="i_content" id="i_content" style="width: 90%"></textarea><p></p></td>
			</tr>
		</table>
	</form>
	</div>
	<br>
	<div align="center">
		<input type="button" value="작성" id="btnInquiryWrite" class="btn">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="목록" id="btnInquiryList" class="btn">
	</div>
</body>
</html>