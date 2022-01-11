<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
<script>
	function find_password() {
		var p_RegExp = /^[a-zA-Z0-9]{8,20}$/; //비밀번호 유효성 검사 정규식

		var Pw = document.getElementById("m_pw"); //비밀번호
		var RePw = document.getElementById("m_pw_chk") //비밀번호 재확인

	
		if (!Id.test(m_id, value)) {
			alert("변경할 아이디가 맞지않습니다. 다시 입력해주세요.");
			return false;
		}

		//패스워드 공백 입력여부 
		if (Pw.value == '') {
			alert("password를 입력해주세요.");
			return false;
		}

		// 비밀번호 재확인 공백 입력여부 
		if (RePw.value == '') {
			alert("비밀번호 재확인을 입력해주세요.");
			return false;
		}

		//패스워드 유효성 
		if (!p_RegExp.test(Pw.value)) {
			alert("password는 8~20자의 영문 대소문자와 숫자로만 입력 해주세요! 다시 입력해주세요.");
			return false;
		}

		//비밀번호 재확인 
		if (Pw.value != RePw.value) {
			alert("비밀번호 재입력이 틀립니다! 다시 입력해주세요.");
			return false;
		}

	}
</script>
</head>
<body>


	<table>
		<h2>변경할 비밀번호를 입력해주세요.</h2>
		<tr>
			<td>
				<form id="change_pw" name="change_pw" action="change_pw"
					method="post" onsubmit="return find_password()">
					
					<div>
						변경할 비밀번호 입력 : <input type="password" id="m_pw" name="m_pw"
							placeholder="비밀번호를 입력하세요.">
					</div>
					<div>
						변경된 비밀번호 재입력 : <input type="password" id="m_pw_chk"
							name="m_pw_chk" placeholder="비밀번호를 입력하세요.">
					</div>

					<div>
						<input type="submit" name="member_pass" value="비밀번호 변경" />
					</div>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>