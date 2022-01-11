<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
		<div align="center"><h2>캠핑장 리스트</h2></div>
		
		<%-- 상세 페이지 이동을 위한 FORM --%>
		<form name="detailForm" id="detailForm">
		<input type="hidden" name="p_number" id="p_number">
		<input type="hidden" name="p_mainphoto" id="p_mainphoto" value="${data.p_mainphoto}" />
		<input type="hidden" id="m_id" name="m_id" value="${id}">
		</form>
		<br>
		<c:choose>		
			<c:when test="${empty productList}">
				<div class="well" style="height: 150px">
				<table align="center">
					<tr>
						<td>	
						<font size="15">등록된 상품이 없습니다.</font>
						</td>
					</tr>
				</table>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${productList}" var="product">
					<div class="well" style="height: 190px">
						<div class="col-sm-4">
							<c:if test="${product.p_type  eq '오토'}">
								<img src="/resources/images/common/1.jpg" class="col-sm-12" width="239.1" height="156.82">
							</c:if>
							<c:if test="${product.p_type eq '글램핑'}">
								<img src="/resources/images/common/2.jpg" class="col-sm-12" width="239.1" height="156.82">
							</c:if>
							<c:if test="${product.p_type eq '차박'}">
								<img src="/resources/images/common/3.jpg" class="col-sm-12" width="239.1" height="156.82">
							</c:if>
						</div>
						<div class="col-sm-8">
							<div class="col-sm-12" align="center">
							<table>
								<tr>
									<td><font size="10"><a href="/product/productDetail?p_number=${product.p_number}">${product.p_name}</a></font></td>
								</tr>
								<tr>
									<c:if test="${product.p_type  eq '오토'}">
									<td><a href="/product/productDetail?p_number=${product.p_number}">안녕하세요. 캠플렉스 오토 캠핑장 입니다.<br> 자세한 내용은 상세 페이지에서 구경하세요.</a></td>
									</c:if>
									<c:if test="${product.p_type eq '글램핑'}">
									<td><a href="/product/productDetail?p_number=${product.p_number}">안녕하세요. 캠플렉스 글램핑 캠핑장 입니다.<br> 자세한 내용은 상세 페이지에서 구경하세요.</a></td>
									</c:if>
									<c:if test="${product.p_type eq '차박'}">
									<td><a href="/product/productDetail?p_number=${product.p_number}">안녕하세요. 캠플렉스 차박 캠핑장 입니다.<br> 자세한 내용은 상세 페이지에서 구경하세요.</a></td>
									</c:if>
								</tr>						
							</table>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

</body>
</html>