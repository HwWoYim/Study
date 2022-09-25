<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String uname=request.getParameter("uname");
	session.setAttribute("uname", uname);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<h1><%=session.getAttribute("uname")%>님, 반갑습니다! :D</h1>
<form action="add.jsp" method="post">
	<select name="product">
		<option>키링</option>
		<option>아이스홍시</option>
		<option>은귀걸이</option>
		<option>식빵</option>
		<option>스마트톡</option>
	</select>
	<input type="submit" value="장바구니에 추가하기">
</form>
<hr>
<a href="result.jsp">구매하기</a>

</body>
</html>