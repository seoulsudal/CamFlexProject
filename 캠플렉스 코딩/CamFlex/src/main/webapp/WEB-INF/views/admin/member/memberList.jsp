<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	
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
<h2 align="center">회원 리스트</h2>
<div align="center">
<form:form modelAttribute="pgrq" method="get" action="memberList${pgrq.toUriStringByPage(1)}">
	<form:select path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input path="keyword"/>
	<button id="searchBtn" class="btn btn-default">검색</button>
</form:form>
</div>
<div id="memberList" align="center">
	<table class="table">
		<thead>
			<tr>
				<td align="center">번호</td>
				<td align="center">아이디</td>
				<td align="center">이름</td>
				<td align="center">전화번호</td>
				<td align="center">가입일</td>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty memberList}">
					<tr>
						<td colspan="5" align="center">회원이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td align="center">${member.m_number}</td>
							<td align="center">${member.m_id}</td>
							<td align="center">${member.m_name}</td>
							<td align="center">${member.m_phone}</td>
							<td align="center"><fmt:formatDate value="${member.m_date}" pattern="yyyy/MM/dd" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<!-- 페이징 네비게이션 -->
	<div>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/admin/member/memberList${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div>
</div>
</body>
</html>