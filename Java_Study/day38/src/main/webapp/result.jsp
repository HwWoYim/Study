<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.MemberBean"%>
<% 
    request.setCharacterEncoding("UTF-8"); 
    %>

<jsp:useBean id="mmb" class="test.MemberManagerBean" scope="session" />
<jsp:useBean id="mb" class="test.MemberBean" />
<jsp:setProperty property="*" name="mb" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	mmb.insert(mb);
	MemberBean data = mmb.selectOne(mb);
%>
	<table border="2">
		<tr>
			<td>이름</td>
			<td><%=data.getUname() %></td>
		</tr>
		<tr>
			<td>점수</td>
			<td><%=data.getScore() %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=data.getGender() %></td>
		</tr>
	</table>
	<hr>
	<a href="main.jsp">메인으로 돌아가기</a>

</body>

</html>