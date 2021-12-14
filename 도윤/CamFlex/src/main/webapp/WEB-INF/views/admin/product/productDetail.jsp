<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
$(function(){
	$("#productModifyBtn").click(function(){
		$("#detailForm").attr({
			"method":"post",
			"action":"/admin/product/updateProduct"
		});	
		$("#detailForm").submit();
	});
	
	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
	
});
$(function(){
	var file = "<c:out value='${detail.p_photo}' />";
	if(file != ""){
		$("#fileImage").attr({
			src:"/uploadStorage/product/${detail.p_photo}",
			width:"450px",
			height:"300px"
		});
	}
});
</script>
</head>
<body>
<div>
	<div align="center"><h2>캠핑장 상세 페이지</h2></div>
	<form id="p_detail" name="p_detail" method = "post">
		<input type="hidden" name="p_number" value="${detail.p_number}"/>
		<input type="hidden" name="p_photo" id="p_photo" value="${detail.p_photo}" />
	</form>
	<form id="detailForm" name="detailForm">
		<table align="center" border="1">
			<tr align="center">
				<td width="400px" height="500px" rowspan="2"><img id="fileImage"></td>
				<td width="600px" height="300px">${detail.p_name}<br>${detail.p_information}<br></td>
			</tr>
			<tr align="center">
				<td>${detail.p_price}</td>
			</tr>
		</table>
	</form>
	<div align="center">
		<input type="button" value="수정" id="productModifyBtn">
		<input type="button" value="목록" id="productListBtn">		
	</div>
</div>
</body>
</html>