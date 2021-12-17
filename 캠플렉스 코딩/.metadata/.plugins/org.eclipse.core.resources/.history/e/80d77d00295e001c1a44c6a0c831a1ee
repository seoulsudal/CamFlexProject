<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 예약</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/include/js/common.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
  	$(function() {
		$("#btnReservation").click(function() {
			$("#reservationForm").attr({
				"method":"POST",
				"action":"/reservation/reservationAgreePage"
			});
			$("#reservationForm").submit();
		});
	});
  	
  	function() {
		
	}
</script>
</head>
<body>
	<div class="col-sm-6">
		<form id="reservationForm" name="reservationForm">
		<div class="panel panel-default" align="center">
			<div>
				<h3>예약 시작일</h3>
			</div>
			<div class="panel-body">
				<input type="date" id="startDate" name="startDate">
			</div>
		</div>
		
		<div class="panel panel-default" align="center">
			<div>
				<h3>예약 종료일</h3>
			</div>
			<div class="panel-body">
				<input type="date" id="endDate" name="endDate">
			</div>
		</div>
		</form>
	</div>
    <div class="col-sm-6">
    	<div align="center">
    		<h2>예약 가능 리스트</h2>
    		<br>
    		<table>
    			<c:choose>
	    			<c:when test="${empty productList}">
	    				<tr>
	    					<td>예약 가능한 게시물이 존재하지 않습니다.</td>	    					
	    				</tr>
	    				<tr>
	    					<td>다른날을 선택해 주세요.</td>	    					
	    				</tr>
	    			</c:when>
	    			<c:otherwise>
	    				<tr>
	    					<td>오메?</td>
	    				</tr>
	    			</c:otherwise>
    			</c:choose>
    				
    			
    		</table>
    	</div>
    	<br>
    	<br>
    	<br>
    	<div align="center">
    		<input type="button" value="예약 하기" style="font-size: 20px; height: 75px; width: 200px;" id="btnReservation" name="btnReservation" class="btn btn-success">
    	</div>
    </div>
	
</body>
</html>