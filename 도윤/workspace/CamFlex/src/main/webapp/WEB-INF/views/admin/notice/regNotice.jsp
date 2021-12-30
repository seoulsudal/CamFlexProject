<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#regNoticeBtn").click(function(){
		if(!chkSubmit($('#n_title'), "공지사항 제목을")) return;
		else if(!chkSubmit($('#n_content'), "내용을"))return;
		
		else{
		if($('#file').val() != ""){
			if(!chkFile($('#file')))return;
		}
		if(confirm('등록을 진핼할까요?')){	
		$("#regNoticeForm").attr({
			"method":"post",
			"action":"/admin/notice/insert"
		});	
		$("#regNoticeForm").submit();
		
		}
		}
	});
	
	$("#noticeListBtn").click(function(){
		location.href="/admin/notice/noticeList";
	});
});
function chkFile(item){
	var ext = item.val().split('.').pop().toLowerCase();
	if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		alert('gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.');
		return false;
	}else{
		return true;	
	}
}
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
	<div align="center"><h3>공지사항 글 작성</h3></div>
	<div align="center">
		<form id="regNoticeForm" name="regNoticeForm" enctype="multipart/form-data">
			<table class="table" border="1">
				<colgroup>
					<col width="15%" />
					<col width="85%" />
				</colgroup>
				<tr>
					<td>글 제목</td>
					<td><input type="text" class="form-control" name="n_title" id="n_title"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><textarea name="n_content" id="n_content" class="form-control" rows="5" cols="50"></textarea></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file" id="file"></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="right">
		<input type="button" value="등록" id="regNoticeBtn" class="btn btn-default">
		<input type="button" value="목록" id="noticeListBtn" class="btn btn-default">
	</div>

</body>
</html>