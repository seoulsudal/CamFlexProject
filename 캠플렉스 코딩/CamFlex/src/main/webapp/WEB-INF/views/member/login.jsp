<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function userLogin() {
		var e_RegExp = /\w+@\w+\.\w+(\.\w+)?/; //아이디(이메일) 정규식

		var id = document.getElementById("m_id");//아이디
		var pw = document.getElementById("m_pw");//비밀번호

		/*===============ID,PW 공백===============*/
		if (id.value == '' || pw.value == '') {
			alert("아이디와 비밀번호를 입력해주세요.");
			return false;
		}

		/*===============아이디 유효성===============*/
		if (id.value == '') {
			alert("아이디를 입력해주세요.");
			id.focus();
			return false;
		}

		if (!e_RegExp.test(id.value)) {
			alert("로그인 아이디는 이메일 형식으로만 가능합니다.");
			return false;
		}
		/*===============비밀번호 유효성===============*/

		if (pw.value == '') {
			alert("비밀번호를 입력해주세요.");
			id.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<div align="center">
	<h2>로그인</h2>
	<form id="loginCheck" name="loginCheck" action="/login/login" method="POST" onsubmit="return userLogin()" >
		
		<div class="input-group" style="width: 280px" align="center">
    		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	   		<input id="m_id" type="text" class="form-control" name="m_id" placeholder="Email">
    	</div>
    	<br>
		<div class="input-group" style="width: 280px">
    		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    		<input id="m_pw" type="password" class="form-control" name="m_pw" placeholder="Password">
    	</div>
		<br>
		<div>
			<input type="submit" class="btn btn-success" value="로그인"/>
			<input type="button" class="btn btn-info" value="아이디 찾기" onClick="location.href='findId'"/>
			<input type="button" class="btn btn-info" value="비밀번호 찾기" onClick="location.href='findPw'"/>
			<input type="button" class="btn btn-primary" value="회원가입" onClick="location.href='join'"/>
		</div>
	</form>
	</div>
</body>
</html>