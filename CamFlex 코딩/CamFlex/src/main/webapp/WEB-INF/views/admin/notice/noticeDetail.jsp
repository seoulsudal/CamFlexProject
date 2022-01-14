<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
	#target{
		width:450px;
		height:300px;
	}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	var file = "<c:out value='${detail.n_photo}' />";
	if(file != ""){
		$("#fileImage").attr({
			src:"/uploadStorage/notice/${detail.n_photo}",
			width:"450px",
			height:"200px"
		});
	}
	
	$("#updateNoticeBtn").click(function(){
		$("#n_detail").attr({
			"method":"post",
			"action":"/admin/notice/updateNotice"
		});	
		$("#n_detail").submit();
	});
	
	$("#noticeListBtn").click(function(){
		location.href="/admin/notice/noticeList";
	});
});
</script>
</head>
<body>
	<div align="center"><h2>공지사항 상세 페이지</h2></div>
	<form id="n_detail" name="n_detail" method = "post" >
		<input type="hidden" name="n_number" id="n_number" value="${detail.n_number}" />
	</form>
		<div align="center">
			<table class="table" border="1">
				<colgroup>
					<col width="15%" />
					<col width="85%" />
				</colgroup>
				<tr>
					<td>글 제목</td>
					<td><input type="text" class="form-control" name="n_title" id="n_title" value="${detail.n_title}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><textarea class="form-control" name="n_content" id="n_content" readonly="readonly">${detail.n_content}</textarea></td>
				</tr>
				<c:if test="${detail.n_photo != ''}">
				<tr>
					<td>이미지</td>
					<td><img id="fileImage"></td>
				</tr>
				</c:if>
			</table>
		
	</div>
	<div align="right">
		<input type="button" value="편집" id="updateNoticeBtn" class="btn btn-default">
		<input type="button" value="목록" id="noticeListBtn" class="btn btn-default">
	</div>

</body>
</html>