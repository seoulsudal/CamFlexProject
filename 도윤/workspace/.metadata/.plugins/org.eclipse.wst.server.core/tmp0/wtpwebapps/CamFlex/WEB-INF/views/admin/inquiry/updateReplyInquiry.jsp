<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 답글 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 작성 버튼 클릭시
		$("#replyBtn").click(function() {
			// 입력값 체크
			
			if(!chkSubmit($('#i_kinds'), "항목을")) return;
			else if(!chkSubmit($('#i_content'), "내용을")) return;
			else{
				if(confirm('등록을 진핼할까요?')){
			$("#updateForm").attr({
				"method":"POST",
				"action":"/admin/inquiry/update"
			});
			$("#updateForm").submit();
			}
			}
		});
	
		// 목록 버튼 클릭시
		$("#inquiryListBtn").click(function() {
			location.href = "/admin/inquiry/inquiryList";
		});
	});
	function chkSubmit(item, msg){
		if(item.val().replace(/\s/g,"") == ""){
			alert(msg + "입력해 주세요.");
			item.val("");
			item.focus();
			return false();
		}else{
			return true;
		}
	}	

</script>

</head>
<body>
<div>
	<h3 align="center">문의사항 답글 수정 페이지</h3>
	<form id="updateForm" name="updateForm">
	<input type="hidden" id="parentNO" name="parentNO" value="${reply.parentNO}">
	<input type="hidden" id="m_id" name="m_id" value="${reply.m_id}">
		<table class="table">
			<colgroup>
				<col width="17%">
				<col width="83%">
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="i_title" id="i_title" value="${reply.i_title}" readonly="true"></td>
			</tr>
			<tr>
				<td>문의 항목</td>
				<td>
					<input type="text" class="form-control" name="i_kinds" id="i_kinds" value="${reply.i_kinds}" readonly="true">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="form-control" name="i_content" id="i_content">${reply.i_content}</textarea></td>
			</tr>
		</table>
	</form>
	<br>
	<div align="right">
		<input type="button" value="등록" id="replyBtn" class="btn btn-default">
		<input type="button" value="목록" id="inquiryListBtn" class="btn btn-default">
	</div>
</div>
</body>
</html>