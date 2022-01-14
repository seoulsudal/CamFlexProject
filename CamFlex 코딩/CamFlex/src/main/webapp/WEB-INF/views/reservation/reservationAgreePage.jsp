<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 결제 및 약관 동의</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/include/js/common.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	
<script type="text/javascript">
  	$(function() {
		$("#BtnReservation").click(function() {
			var agree1 = document.getElementById("p_u_agree");
			var agree2 = document.getElementById("c_agree");
			var agree3 = document.getElementById("p_i_agree");
			var agree4 = document.getElementById("a_agree");
			
			// 입력값 체크
			if(!agree1.checked){
				alert("이용시 유의사항에 동의를 체크해 주세요.");
				return false;
			} else if(!agree2.checked){
				alert("취소 수수료에 동의를 체크해 주세요.");
				return false;
			} else if(!agree3.checked){
				alert("개인정보 수집 및 이용에 동의를 체크해 주세요.");
				return false;
			} else if(!agree4.checked){
				alert("예약자가 성인임에 동의를 체크해 주세요.");
				return false;
			} else {
				$("#agreeForm").attr({
					"method":"POST",
					"action":"/reservation/reservationRegister"
				});
				$("#agreeForm").submit();		
			}
		});
  		
		$("#BtnProductList").click(function(){
			location.href="/product/productList";
		});
		
  	});
</script>
</head>
<body>
	<div class="col-sm-12">
	<form id="agreeForm">
		<%-- 예약을 위한 Form --%>
		<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}"/>
		<input type="hidden" name="p_price" id="p_price" value="${detail.p_price}"/>
		<input type="hidden" id="r_startDate" name="r_startDate" value="${reservation.r_startDate}" />
		<input type="hidden" id="r_endDate" name="r_endDate" value="${reservation.r_endDate}" />
		<input type="hidden" id="r_price" name="r_price" value="${detail.p_price * resultDate}">
		<input type="hidden" id="m_id" name="m_id" value="${id}">
		<input type="hidden" id="r_state" name="r_state" value="대기">
		
		<div align="center">
			<h2>이용약관 동의</h2>
		</div>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">이용 시 유의사항에 동의</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						- 당일 예약 불가능. 일주일 전부터 예약 가능<br> - 예약 최대 기간은 1개월 이내<br> -
						예약 변경은 불가 (취소 후 재 예약 가능)<br> - 제품 가격에 맞춰 손해배상 청구<br> <br>
						- 기본 제공사항<br> - 공용 화장실<br> - 공용 샤워장<br> - 릴선<br>
						- 코로나19 방역소독
					</div>
				</div>
			</div>
			<br>
			<div align="center">
				<label class="radio-inline"> <input type="checkbox" id="p_u_agree" value="1">동의</label>
			</div>
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse2">취소 수수료에 동의</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">
						- 환불규정<br> - 이용 8일전 수수료 없음<br> - 이용 6~7일전 총 금액의 20% 차감<br>
						- 이용 5~4일전 총 금액의 30% 차감<br> - 이용 2~3일전 총 금액의 40% 차감<br>
						- 이용 1일전 총 금액의 50% 차감<br> - 이용 당일 환불 불가
					</div>
				</div>
			</div>
			<br>
			<div align="center">
				<label class="radio-inline"> <input type="checkbox" id="c_agree" value="1">동의</label>
			</div>
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">개인정보 수집 및 이용에 동의</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">
						1.개인정보 수집목적 및 이용목적<br> 가. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산,
						콘텐츠 제공, 구매 및 요금 결제,<br> 물품배송 또는 청구지 등 발송, 금융거래 본인 인증 및 금융 서비스<br>
						나. 회원 관리<br> 회원제 서비스 이용에 따른 본인확인, 개인 식별, 불량회원의 부정 이용 방지와 비인가
						사용 방지,<br> 가입 의사 확인, 연령확인, 만14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부
						확인, 불만처리 등 민원처리, 고지사항 전달<br> 2.수집하는 개인정보 항목 : 이름, 로그인ID,
						비밀번호, 주소, 휴대전화번호, 이메일, 14세미만 가입자의 경우 법정대리인의 정보<br> 3.개인정보의
						보유기간 및 이용기간 원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당<br> 정보를 지체 없이
						파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존.<br> 가. 회사 내부 방침에
						의한 정보 보유 사유<br> o 부정거래 방지 및 운영방침에 따른 보관 : 5년<br> 나. 관련
						법령에 의한 정보보유 사유<br> o 계약 또는 청약철회 등에 관한 기록<br> -보존이유 :
						전자상거래등에서의소비자보호에관한법률<br> -보존기간 : 5년<br> o 대금 결제 및 재화 등의
						공급에 관한 기록<br> -보존이유: 전자상거래등에서의소비자보호에관한법률<br> -보존기간 : 5년<br>
						o 소비자 불만 또는 분쟁처리에 관한 기록<br> -보존이유 : 전자상거래등에서의소비자보호에관한법률<br>
						-보존기간 : 3년<br> ※ 동의를 거부할 수 있으나 거부시 회원 가입이 불가능합니다.
					</div>
				</div>
			</div>
			<br>
			<div align="center">
				<label class="radio-inline"> <input type="checkbox" id="p_i_agree" value="1">동의</label>
			</div>
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse4">이용자가 미성년자가 아니며 성인임에 동의</a>
					</h4>
				</div>
				<div id="collapse4" class="panel-collapse collapse">
					<div class="panel-body">미성년자 입실 혼숙 금지 (관계 법령 의거)</div>
				</div>
			</div>
			<br>
			<div align="center">
				<label class="radio-inline"> <input type="checkbox" id="a_agree" value="1">동의</label>
			</div>
			<br>
		</div>
	</form>
	</div>
	<div class="col-sm-12">
		<div align="center">
			<h2>예약 내용 확인</h2>
		</div>
		<div class="well">
			<table>
				<tr>
					<td><font size="4">객실 정보 : ${detail.p_name}</font></td>
				</tr>
				<tr>
					<td><font size="4">예약 시작날짜 : ${reservation.r_startDate}</font></td>
				</tr>
				<tr>
					<td><font size="4">예약 종료날짜 : ${reservation.r_endDate}</font></td>
				</tr>
				<tr>
					<td><font size="4">총 예약일 : ${resultDate}일</font></td>
				</tr>
				<tr>
					<td><font size="4">예약자 정보 : 회원 정보</font></td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<div class="col-sm-12">
		<div align="center">
			<h2>업체 계좌번호 및 결제 금액</h2>
		</div>
		<div class="well" align="center" >
		<table>
				<tr>
					<td align="left"><font size="4">계좌번호 : **은행 0000 – 000 – 000000</font></td>
				</tr>
				<tr>
					<td align="left"><font size="4">예 금 주 : * * *</font></td>
				</tr>
				<tr align="center">
					<td><font size="4">결제 금액</font></td>
				</tr>
				<tr align="center">
					<td><font size="4"><fmt:formatNumber value="${detail.p_price * resultDate}" pattern="#,###원"/></font></td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<div class="col-sm-12" align="center">
		<br>
		<input type="button" value="예약" id="BtnReservation" class="btn btn-success" style="font-size: 20px; height: 75px; width: 150px;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="목록" id="BtnProductList" class="btn btn-success" style="font-size: 20px; height: 75px; width: 150px;">
	</div>
</body>
</html>