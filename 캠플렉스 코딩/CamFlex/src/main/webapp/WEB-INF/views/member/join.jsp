<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(function(){
	$("#registerBtn").click(function(){
		if(!chkSubmit($('#m_id'), "아이디를")) return;
		else if(!chkSubmit($('#m_pw'), "비밀번호를")) return;
		else if(!chkSubmit($('#m_name'), "이름을"))return;
		else if(!chkSubmit($('#m_birth'), "생년월일을"))return;
		else if(!chkSubmit($('#m_phone'), "전화번호를"))return;
		else{
		if(confirm('등록을 진핼할까요?')){	
		$("#regForm").attr({
			"method":"POST",
			"action":"/member/insertMember"
		});	
		$("#regForm").submit();
		
		}
		}
	});	
	$("#homeBtn").on("click", function(){
		self.location = "/";
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
	<div align="center" ><h3>회원 등록</h3></div>
	<div align="center">
		<form id="regForm" name="regForm">
			<table class="table" border="1">
				<colgroup>
					<col width="17%" />
					<col width="83%" />
				</colgroup>
				<tr>
					<td>ID</td>
					<td><input type="text" class="form-control" name="m_id" id="m_id" /></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" class="form-control" name="m_pw" id="m_pw" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" name="m_name" id="m_name" /></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" class="form-control" name="m_birth" id="m_birth" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" class="form-control" name="m_phone" id="m_phone" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="right">
		<input type="button" value="등록" id="registerBtn" class="btn btn-default">
	</div>
</div>
</body>
</html>