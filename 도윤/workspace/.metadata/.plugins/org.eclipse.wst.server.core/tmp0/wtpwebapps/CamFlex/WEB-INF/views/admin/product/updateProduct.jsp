<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
$(function(){
	var value = "${update.p_mainphoto}";
	if(value != ""){
		var img = $("<img>");
		$("#imgView").hover(function(){
			img.attr({
				src:"/uploadStorage/product/${update.p_mainphoto}",
				width:"200px",
				height:"100px"
			});
			img.addClass("imgViewDate");
			$("#imgArea").append(img);
		},function(){
			img.remove();
		});
	}else{
		$('#imgView').hide();
	}
});
	$(function(){
		var value = "${update.p_photo1}";
		if(value != ""){
			var img = $("<img>");
			$("#imgView1").hover(function(){
				img.attr({
					src:"/uploadStorage/product/${update.p_photo1}",
					width:"200px",
					height:"100px"
				});
				img.addClass("imgViewDate");
				$("#imgArea1").append(img);
			},function(){
				img.remove();
			});
		}else{
			$('#imgView1').hide();
		}
	});
		$(function(){
			var value = "${update.p_photo2}";
			if(value != ""){
				var img = $("<img>");
				$("#imgView2").hover(function(){
					img.attr({
						src:"/uploadStorage/product/${update.p_photo2}",
						width:"200px",
						height:"100px"
					});
					img.addClass("imgViewDate");
					$("#imgArea2").append(img);
				},function(){
					img.remove();
				});
			}else{
				$('#imgView2').hide();
			}
		});
$(function(){
				var value = "${update.p_photo3}";
				if(value != ""){
					var img = $("<img>");
					$("#imgView3").hover(function(){
						img.attr({
							src:"/uploadStorage/product/${update.p_photo3}",
							width:"200px",
							height:"100px"
						});
						img.addClass("imgViewDate");
						$("#imgArea3").append(img);
					},function(){
						img.remove();
					});
				}else{
					$('#imgView3').hide();
				}
			});
$(function(){
	$("#updateProductBtn").click(function(){
		if(!chkSubmit($('#p_type'), "상품 구분을")) return;
		else if(!chkSubmit($('#p_name'), "상품명을")) return;
		else if(!chkSubmit($('#p_price'), "상품 금액을"))return;
		else if(!chkSubmit($('#p_information'), "상품 안내를"))return;
		else if(!chkSubmit($('#file'), "이미지를")) return;
		else if(!chkSubmit($('#file1'), "이미지를")) return;
		else if(!chkSubmit($('#file2'), "이미지를")) return;
		else if(!chkSubmit($('#file3'), "이미지를")) return;
		else{
			if($('#file').val() != ""){
				if(!chkFile($('#file')))return;
			}
			if(confirm('수정을 진핼할까요?')){
		$("#updateProductForm").attr({
			"method":"post",
			"action":"/admin/product/update"
		});	
		
		$("#updateProductForm").submit();
		}
		}
	});

	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
});	
function chkFile(item){

	var ext = item.val().split('.').pop().toLowerCase();
	if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		alert('gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.');
		return false;
	}else{
		return true;	
	}
	
}
function chkSubmit(item, msg){
	if(item.val().replace(/\s/g,"") == ""){
		alert(msg + "입력해 주세요.");
		item.val("");
		item.focus();
		return false();
	}else{
		return true;
	}
}
</script>
</head>
<body>
	<div>
		<div align="center">
			<h3>상품 수정</h3>
		</div>
		<div align="center">
			<form id="updateProductForm" name="updateProductForm"
				enctype="multipart/form-data">
				<input type="hidden" id="p_number" name="p_number" value="${update.p_number}" />
				<input type="hidden"id="p_mainphoto" name="p_mainphoto" value="${update.p_mainphoto}" />
				<input type="hidden" id="p_photo1" name="p_photo1" value="${update.p_photo1}" />
				<input type="hidden" id="p_photo2" name="p_photo2" value="${update.p_photo2}" /> 
				<input type="hidden" id="p_photo3" name="p_photo3" value="${update.p_photo3}" />
				<table class="table" border="1">
					<colgroup>
						<col width="17%" />
						<col width="83%" />
					</colgroup>
					<tr>
						<td>구분</td>
						<td><select class="form-control" id="p_type" name="p_type">
								<option value="오토">오토</option>
								<option value="글램핑">글램핑</option>
								<option value="차박">차박</option>
						</select></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><input type="text" class="form-control" name="p_name" id="p_name"
							value="${update.p_name}" required="required" placeholder="상품명" /></td>
					</tr>
					<tr>
						<td>가격</td>
						<td><input type="text" class="form-control" name="p_price" id="p_price"
							value="${update.p_price}" required="required" placeholder="가격" /></td>
					</tr>
					<tr>
						<td>상품 안내</td>
						<td><textarea id="p_information" name="p_information"
								maxlength="2000" class="form-control" rows="5" cols="50" placeholder="상품 안내">${update.p_information}</textarea></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="file" id="file"><span
							id="imgView">기존 이미지 파일명: ${update.p_mainphoto}<span
								id="imgArea"></span></span></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="file1" id="file1"
							value="p_photo1"><span id="imgView1">기존 이미지 파일명:
								${update.p_photo1}<span id="imgArea1"></span>
						</span></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="file2" id="file2"
							value="p_photo2"><span id="imgView2">기존 이미지 파일명:
								${update.p_photo2}<span id="imgArea2"></span>
						</span></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="file3" id="file3"
							value="p_photo3"><span id="imgView3">기존 이미지 파일명:
								${update.p_photo3}<span id="imgArea3"></span>
						</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div align="right">
			<input type="button" value="수정" id="updateProductBtn" class="btn btn-default"> <input
				type="button" value="목록" id="productListBtn" class="btn btn-default">
		</div>
	</div>
</body>
</html>