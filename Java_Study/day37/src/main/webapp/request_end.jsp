<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

요청 메서드: <%=request.getMethod()%> <br>
<table border="1">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("uname")%></td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<%=request.getParameter("job")%>
			</td>
		</tr>
		<tr>
			<td>관심 컨텐츠</td>
			<td>
				<%
					String[] fav=request.getParameterValues("fav");
					for(int i=0;i<fav.length;i++){
						out.println(fav[i]+"<BR>");
					}
					for(String v:fav){
						out.println(v+"<BR>");
					}
				%>
			</td>
		</tr>
</table>
	
</body>
</html>