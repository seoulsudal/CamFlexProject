<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 리스트</title>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit"><h3>캠핑장 리스트</h3></div>
		
		<%-- 상세 페이지 이동을 위한 FORM --%>
		<form name="detailForm" id="detailForm">
		<input type="hidden" name="p_number" id="p_number">
		</form>
		
		<%-- 리스트 시작 --%>
		<div id="productList">
		<table summary="캠핑장 리스트">
			<colgroup>
				<col width="10%"/>
				<col width="62%"/>
				<col width="15%"/>
				<col width="13%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="order">캠핑장 번호</th>
				</tr>
			</thead>
		</table>
		</div>
	</div>
</body>
</html>