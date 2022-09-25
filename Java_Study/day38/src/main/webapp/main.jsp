<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.MemberBean" %>
	<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="mmb" class="test.MemberManagerBean" scope="session"/>
	<jsp:useBean id="mb" class="test.MemberBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="form.html">등록 페이지로 가기</a>
<hr>
<ol>
<%
	for(MemberBean v:mmb.selectAll(mb)){
%>
	<li><%= v.getUname()%> <%= v.getScore()%> <%= v.getGender()%></li>
<%
 	}
%>
</ol>
</body>
</html>