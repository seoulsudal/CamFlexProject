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
	.views{list-style : none;}
	
	#target{
		width:450px;
		height:300px;
		margin: 0px 10px;
	}
	
	.small{
		width:90px;
		height:60px;
	}
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
	// 예약 버튼 클릭 시
	$("#productReservation").click(function(){
		$("#p_detail").attr({
			"method":"post",
			"action":"/reservation/reservationDetail"
		});	
		$("#p_detail").submit();
	});
	
	// 목록 버튼 클릭 시
	$("#productListBtn").click(function(){
		location.href="/product/productList";
	});
	
});

function setImage(index){
	var image_list = ['/uploadStorage/product/${detail.p_mainphoto}',
					  '/uploadStorage/product/${detail.p_photo1}', 
					  '/uploadStorage/product/${detail.p_photo2}', 
					  '/uploadStorage/product/${detail.p_photo3}'];
	
	var image = document.getElementById("target");
	
	image.src = image_list[index];
}
</script>
</head>
<body>
<div class="col-sm-12">
	<div align="center"><h2>캠핑장 상세 페이지</h2></div><br>
	<%-- 예약 상세 페이지 이동을 위한 FORM --%>
	<form id="p_detail" name="p_detail" method = "post">
		<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}"/>
		<input type="hidden" name="p_name" id="p_name" value="${detail.p_name}"/>
		<input type="hidden" name="p_price" id="p_price" value="${detail.p_price}"/>
		<input type="hidden" id="m_id" name="m_id" value="${id}">
	</form>
	<div class="well">
		<table border="1">
			<tr align="center">
				<td width="400px" height="500px" rowspan="2"><div>
				<img id="target" src="/uploadStorage/product/${detail.p_mainphoto}" class="img-rounded"></div>
				<br><br><br>
				<div>
				<ul class="views">
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(0)">
					<img id="photo1" class="small img-rounded" src="/uploadStorage/product/${detail.p_mainphoto}">
					</a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(1)">
					<img id="photo2" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo1}">
					</a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(2)">
					<img id="photo3" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo2}">
					</a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(3)">
					<img id="photo4" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo3}">
					</a></li>
				</ul></div></td>
				<td width="500px" height="300px" class="text-primary">
				<h3>상품번호 : ${detail.p_number}<br> 상품명 : ${detail.p_name}</h3><br>${detail.p_information}<br>
				</td>
			</tr>
			<tr align="center">
				<td><h2>가격 안내</h2><br><h3>1박 당&nbsp;<fmt:formatNumber value="${detail.p_price}" pattern="#,###원"/></h3></td>
			</tr>
		</table>
	</div>
	<div align="center">
		<br>
		<input type="button" value="예약" id="productReservation" class="btn btn-success" style="font-size: 20px; height: 75px; width: 150px;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="목록" id="productListBtn" class="btn btn-success" style="font-size: 20px; height: 75px; width: 150px;">
	</div>
	
	<div>
		<jsp:include page="reviewList.jsp"></jsp:include>
	</div>
</div>
</body>
</html>