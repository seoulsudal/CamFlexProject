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
</script>
</head>
<body>
	<form id="cancelCheck" name="cancelCheck" method="GET">
		<input type="hidden" id="m_id" name="m_id" value="${m_id}"> <input
			type="hidden" id="r_number" name="r_number" value="${r_number}">
		<input type="hidden" id="r_price" name="r_price" value="${r_price}">
		<input type="hidden" id="r_startDate" name="r_startDate"
			value="${r_startDate}"> <input type="hidden" id="price_fee"
			name="price_fee" value="${p_fee} "> <input type="hidden"
			id="total_price" name="total_price" value="${total_price} ">



		<table class="table">
			<tr>
				<td align="center">결제금액</td>
				<td align="center"><input id="r_price" name="r_price" value="${r_price}"
					readonly="true" /></td>
			</tr>
			<tr>
				<td align="center">취소수수료</td>
				<td align="center"><input id="price_fee" name="price_fee" value="${p_fee}"
					readonly="true" /></td>
			</tr>
			<tr>
				<td align="center">환불금액</td>
				<td align="center"><input id="total_price" name="total_price"
					value="${total_price}" readonly="true" /></td>
			</tr>

			<tr>
				<td align="center">취소 사유</td>
				<td align="center"><select id="r_cancel" name="r_cancel">
						<option value="개인사유">개인사유</option>
						<option value="예약날짜변경">예약날짜변경</option>
						<option value="천재지변">천재지변</option>
						<option value="기타">기타</option>
				</select></td>

			</tr>

			<tr>
				<!-- 취소 환불 규정 안내문 -->
			</tr>

			<tr>
				<td colspan="2"  align="center"><input type="button" id="btnCancel" name="btnCancel"
					value="예약 취소하기" class="btn btn-success"/></td>
			</tr>


		</table>
	</form>
</body>
</html>