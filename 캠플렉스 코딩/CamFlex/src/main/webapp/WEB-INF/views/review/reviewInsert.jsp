<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 작성</title>
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
		$("#btnReviewInsert").click(function() {
			// 입력값 체크
			if(!chkSubmit($('#rv_content'), "내용을")) return;
			else{
			$("#writeForm").attr({
				"method":"POST",
				"action":"/review/reviewInsert"
			});
			$("#writeForm").submit();
			}
		});
	
		// 취소 버튼 클릭시
		$("#btnMemberList").click(function() {
			location.href = "/member/pastList";
		});
	});
</script>

</head>
<body>
	<div align="center">
		<h2>댓글 작성</h2>
	</div>
	<br>
	<div class="well" align="center">
	<form id="writeForm" name="writeForm">
		<input type="hidden" name="m_id" id="m_id" value="${id}">
		<input type="hidden" name="p_number" id="p_number" value="${p_number}">
		<table style="text-align: center; width: 90%;" class="table">
			<tr>
				<td>내용</td>
				<td><textarea name="rv_content" id="rv_content" style="width: 90%"></textarea><p></p></td>
			</tr>
		</table>
	</form>
	</div>
	<br>
	<div align="center">
		<input type="button" value="작성" id="btnReviewInsert" class="btn">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="취소" id="btnMemberList" class="btn">
	</div>
</body>
</html>