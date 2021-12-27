<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑 상품 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".goDetail").click(function(){
		var p_number = $(this).parents("tr").attr("data-num");
		$("#p_number").val(p_number);
		console.log("상품 번호 : " + p_number);
		
		$("#listForm").attr({
			"method":"get",
			"action":"/admin/product/productDetail"
		});
		$("#listForm").submit();
	});
});
</script>
</head>
<body>
<div>
	<div><h3 align="center">캠핑 리스트</h3></div>
	
	<form name="listForm" id="listForm">
		<input type="hidden" name="p_number" id="p_number">
	</form>

	<div id="productList" align="center">
		<table border="1">
			<colgroup>
				<col width="10%" />
				<col width="20%" />
				<col width="50%" />
				<col width="20%" />
			</colgroup>
			<thead>
				<tr>
					<th class="order">상품번호</th>
					<th>구분</th>
					<th>상품명</th>
					<th data-value="p_date" class="order">등록일</th>
				</tr>
			</thead>
			<tbody id="list">
				
				<c:choose>
					<c:when test="${not empty productList}">
						<c:forEach var="pro" items="${productList}" varStatus="status">
							<tr data-num="${pro.p_number}">
								<td align="center">${pro.p_number}</td>
								<td align="center">${pro.p_type}</td>
								<td class="goDetail tal" align="center">${pro.p_name}</td>
								<td align="center"><fmt:formatDate value="${pro.p_date}" pattern="yyyy/MM/dd" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" align="center">등록된 상품이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>