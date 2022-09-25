<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- 페이지 설정한 것을 표현 --%>
<!-- 표지페이지 -->
<!-- main.jsp에서 datas를 출력하려면 C를 방문해야하기때문 -->
<jsp:forward page="login.jsp" /> <!-- forward로 인해 현재 실행중인 페이지와 forward에 의해 호출 될 페이지가 request, response,객체를 공유한다. -->
<%
	// pageContext.forward("controller.jsp?action=main");
%>