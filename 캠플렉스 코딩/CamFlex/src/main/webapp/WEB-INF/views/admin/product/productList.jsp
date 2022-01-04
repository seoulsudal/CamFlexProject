<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	$(function() {
		$("#insertFormBtn").click(function() {
			location.href = "/admin/product/regProduct";
		});

		$(".goDetail").click(function() {
			var p_number = $(this).parents("tr").attr("data-num");
			$("#p_number").val(p_number);
			console.log("상품 번호 : " + p_number);

			$("#listForm").attr({
				"method" : "get",
				"action" : "/admin/product/productDetail"
			});
			$("#listForm").submit();
		});
	});
</script>
</head>
<body>
	<div>
		<div>
			<h3 align="center">캠핑 리스트</h3>
		</div>

		<form name="listForm" id="listForm">
			<input type="hidden" name="p_number" id="p_number">
		</form>

		<div id="productList" align="center">
			<table class="table">
				<colgroup>
					<col width="10%" />
					<col width="20%" />
					<col width="50%" />
					<col width="20%" />
				</colgroup>
				<thead>
					<tr>
						<td align="center" class="order">상품번호</td>
						<td align="center">구분</td>
						<td align="center">상품명</td>
						<td align="center" data-value="p_date" class="order">등록일</td>
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
									<td align="center"><fmt:formatDate value="${pro.p_date}"
											pattern="yyyy/MM/dd" /></td>
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
			<!-- 페이징 네비게이션 -->
			<div>
				<c:if test="${pagination.prev}">
					<a href="${pagination.startPage - 1}">&laquo;</a>
				</c:if>
				<c:forEach begin="${pagination.startPage}"
					end="${pagination.endPage}" var="idx">
					<a href="/admin/product/productList${pagination.makeQuery(idx)}">${idx}</a>
				</c:forEach>
				<c:if test="${pagination.next && pagination.endPage > 0}">
					<a href="${pagination.endPage + 1}">&raquo;</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>