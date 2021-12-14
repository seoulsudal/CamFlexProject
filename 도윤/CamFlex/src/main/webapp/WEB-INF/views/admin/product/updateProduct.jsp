<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
$(function(){
	$("#updateProductBtn").click(function(){
		$("#updateProductForm").attr({
			"method":"post",
			"action":"/admin/product/updateProduct"
		});	
		$("#updateProductForm").submit();
	});
	
	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
});
function chkFile(item){
    alert("aaa");
	var ext = item.val().split('.').pop().toLowerCase();
	if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		alert('gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.');
		return false;
	}else{
		return true;	
	}
}
</script>
</head>
<body>
<div>
	<div align="center"><h3>상품 수정</h3></div>
	<div align="center">
		<form id="updateProductForm" name="updateProductForm" enctype="multipart/form-data">
			<input type="hidden" id="p_number" name="p_number" value="${update.p_number}" />
			<input type="hidden" id="p_photo" name="p_photo" value="${update.p_photo}" />
			<table border="1">
				<colgroup>
					<col width="17%" />
					<col width="83%" />
				</colgroup>
				<tr>
					<td>구분</td>
					<td><select id="p_type" name="p_type">
							<option value="오토">오토</option>
							<option value="글램핑">글램핑</option>
							<option value="차박">차박</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="p_name" id="p_name" value="${update.p_name}" required="required" placeholder="상품명"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="p_price" id="p_price" value="${update.p_price}" required="required" placeholder="가격"/></td>
				</tr>
				<tr>
					<td>상품 안내</td>
					<td><textarea id="p_information" name="p_information" maxlength="2000" rows="8" cols="50" placeholder="상품 안내"></textarea></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file" id="file" value="${update.file}"></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<input type="button" value="수정" id="updateProductBtn">
		<input type="button" value="목록" id="productListBtn">
	</div>
</div>
</body>
</html>