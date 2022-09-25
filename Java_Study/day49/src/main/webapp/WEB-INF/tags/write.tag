<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type" %>
<%@ attribute name="bid" %>
<%@ attribute name="mid" %>

<!-- 로그인이 되었다면(uid에 값이 있다면) -->
<c:if test="${uid != null}">
<c:choose>
	<c:when test="${type=='msg'}">	<!-- test:필수 속성으로 속성값으로 EL식 비교식을 가진다. -->
	<form action="insertB.do?cnt=${cnt}" me
	thod="post">
		<input type="hidden" name="mid" value="${uid}">
		<input type="hidden" name="cnt" value="${cnt}">
		<input type="text" name="msg">
		<input type="submit" value="글 등록">
	</form>
	</c:when>
	
	<c:when test="${type=='rmsg'}">
	<form action="insertR.do?cnt=${cnt}" method="post">
		<input type="hidden" name="mid" value="${uid}">
		<input type="hidden" name="bid" value="${bid}">
		<input type="hidden" name="cnt" value="${cnt}">
		댓글: <input type="text" name="rmsg">
		<input type="submit" value="댓글 등록">
	</form>
	</c:when>
</c:choose>
</c:if> 



<c:if test="${uid == null}">
<c:choose>
	<c:when test="${type=='msg'}">
		<input type="text" disabled value="등록하려면 로그인하세요!">
	</c:when>
	
	<c:when test="${type=='rmsg'}">
		댓글: <input type="text" disabled value="등록하려면 로그인하세요!">
	</c:when>
</c:choose>
</c:if>