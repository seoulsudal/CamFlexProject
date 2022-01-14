<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<style type="text/css">

</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

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
	
	$("#BtnNoticeList").click(function(){
		location.href="/notice/noticeList";
	});	
});
</script>
</head>
<body>
<div class="col-sm-12">
	<div align="center"><h2>공지사항 상세 페이지</h2></div>
	<input type="hidden" name="m_id" id="m_id" value="${id}">
	<br>
		<div class="well" align="center">
			<table border="1" class="table">
				<tr>
					<td align="center"><font size="5">글 제목</font></td>
					<td align="center"><font size="5">${detail.n_title}</font></td>
				</tr>
				<tr>
					<td align="center"><font size="5">글 내용</font></td>
					<td width="500px" height="300px" ><font size="3">${detail.n_content}</font></td>
				</tr>
				<c:if test="${detail.n_photo != ''}">
				<tr>
					<td align="center"><font size="5">이미지</font></td>
					<td align="center"><img id="fileImage"></td>
				</tr>
				</c:if>
			</table>
	</div>
	<div align="center">
		<input type="button" value="목록" id="BtnNoticeList" class="btn">
	</div>
</div>
</body>
</html>