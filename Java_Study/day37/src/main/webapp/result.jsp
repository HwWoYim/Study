<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
</head>
<body>

<h1><%=session.getAttribute("uname")%>님이 구매한 상품 목록</h1>
<hr>
<ol>
<%
	ArrayList<String> datas=(ArrayList)session.getAttribute("datas");
	if(datas==null){
		out.println("<h2>구매한 상품이 없습니다!</h2>");
	}
	else{
		for(String v:datas){
			out.println("<li>"+v+"</li>");
		}
	}
%>
</ol>

</body>
</html>