<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

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

<script type="text/javascript">
$(function(){
	$("#productModifyBtn").click(function(){
		$("#p_detail").attr({
			"method":"post",
			"action":"/admin/product/updateProduct"
		});	
		$("#p_detail").submit();
	});
	
	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
});
function setImage(index){
	var image_list = ['/uploadStorage/product/${detail.p_mainphoto}', '/uploadStorage/product/${detail.p_photo1}', '/uploadStorage/product/${detail.p_photo2}', '/uploadStorage/product/${detail.p_photo3}'];
	
	var image = document.getElementById("target");
	
	image.src = image_list[index];
}
</script>
</head>
<body>
<div class="col-sm-12">
	<div align="center"><h2>캠핑장 상세 페이지</h2></div>
	<form id="p_detail" name="p_detail" method = "post">
		<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}"/>
		<input type="hidden" name="p_mainphoto" id="p_mainphoto" value="${detail.p_mainphoto}" />
		<input type="hidden" name="p_photo1" id="p_photo1" value="${detail.p_photo1}"/>
		<input type="hidden" name="p_photo2" id="p_photo2" value="${detail.p_photo2}"/>
		<input type="hidden" name="p_photo3" id="p_photo3" value="${detail.p_photo3}"/>
	</form>
	<div>
		<table class="table" align="center" border="1">
			<tr align="center">
				<td width="400px" height="500px" rowspan="2"><div><img id="target" src="/uploadStorage/product/${detail.p_mainphoto}" class="img-rounded"></div><br>
				<br><br>
				<div>
				<ul class="views">
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(0)"><img id="photo1" class="small img-rounded" src="/uploadStorage/product/${detail.p_mainphoto}" width="75" height="45"></a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(1)"><img id="photo2" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo1}" width="75" height="45"></a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(2)"><img id="photo3" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo2}" width="75" height="45"></a></li>
					<li style="float: left; margin-right : 10px;"><a href="#" onclick="setImage(3)"><img id="photo4" class="small img-rounded" src="/uploadStorage/product/${detail.p_photo3}" width="75" height="45"></a></li>
				</ul></div></td>
				<td width="600px" height="300px"><h3>${detail.p_name}</h3><br><br><br><br><br>${detail.p_information}<br></td>
			</tr>
			<tr align="center">
				<td><h3>${detail.p_price}원</h3><br><br><br><br>부대시설 및 렌탈 가격 안내<br>...</td>
			</tr>
		</table>
	</div>
	<div align="right">
		<input type="button" value="수정" id="productModifyBtn" class="btn btn-default">
		<input type="button" value="목록" id="productListBtn" class="btn btn-default">
		<!-- <input type="button" value="삭제" id="productDeleteBtn"> -->	
	</div>
</div>
</body>
</html>