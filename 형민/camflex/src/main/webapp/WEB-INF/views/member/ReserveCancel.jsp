<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 취소</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function price_fee() {

		var today = new Date(); //현재 날짜
		var startDate = document.getElementById("r_startdate");//예약 시작날짜

		var price = document.getElementById("r_price"); // 총 금액
		var fee = 0; //수수료

		var year = today.getFullYear(); //연도
		var month = now.getMonth(); //월
		var day = now.getDate(); //일

		var stDate = new Date(startDate_arr[0], startDate_arr[1],
				startDate_arr[2]);
		var nowDate = new Date(year, month, day);

		var btMs = stDate.getTime() - nowDate.getTime();
		var btDay = btMs / (1000 * 60 * 60 * 24);

		if (btDay >= 8) {
			fee = 1;
		}

		if (btDay >= 6 && btDay <= 7) {
			fee = 0.2;

		}

		if (btDay >= 4 && btDay <= 5) {
			fee = 0.3;

		}

		if (btDay >= 2 && btDay <= 3) {
			fee = 0.4;
		}

		if (btDay == 1) {
			fee = 0.5;
		}

		var price_fee = price * fee

		console.log(price_fee);

		//var diff = today - startDate;
		//var currDay = 24*60*60*1000;

		$(function() {
			//예약 취소하기 버튼 클릭시 
			$("#btnCancel").click(function() {
				$("#cancelCheck").attr({
					"method" : "POST",
					"action" : "/member/cancel"
				});
				$("#cancelCheck").submit();
			});

		});

	}}
</script>
</head>
<body>
	<form id="cancelCheck" name="cancelCheck">
		<input type="hidden" id="m_id" name="m_id" value="${list.m_id}">
		<input type="hidden" name="r_number" id="r_number" value="${r_number }">
		<input type="hidden" id="r_price " name="r_price " value="${r_price }">
	</form>
	<table>
		<tr>
			<td>결제금액</td>
			<td><input name="${list.r_price}" /></td>
		</tr>
		<tr>
			<td>취소수수료</td>
			<td><input name=price_fee /></td>
		</tr>
		<tr>
			<td>환불금액</td>
			<td></td>
		</tr>
		<tr>
			<td>취소 사유</td>
			<td></td>
		</tr>

		<tr>
			<td><input type="button" id="btnCancel" value="예약 취소하기" /></td>
		</tr>
	</table>
</body>
</html>