<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="deleteM.do" method="post">
	<input type="hidden" name="action" value="deleteM">
	<c:if test="${uid==null}">
        ID&nbsp;<input type="text" name="mid" value="${uid}">&nbsp;&nbsp;
    </c:if>
		PW&nbsp;<input type="password" name="mpw" placeholder="비밀번호 확인">
	<input type="submit" value="회원탈퇴">
</form>