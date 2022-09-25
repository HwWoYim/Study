<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mDAO" class="model.dao.MemberDAO" />
<jsp:useBean id="mVO" class="model.vo.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<%
	if(request.getMethod().equals("POST")){		
		if(mDAO.insert(mVO)){
			out.println("<SCRIPT>alert('"+request.getParameter("name")+" 등록완료!');</SCRIPT>");
		}
		else{
			out.println("<SCRIPT>alert('등록실패...');</SCRIPT>");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>

<form action="NewFile.jsp" method="post">
이름: <input type="text" name="name"> <br>
점수: <input type="number" min="0" max="100" name="score"> <br>
<input type="submit" value="데이터 등록하기">
</form>

<hr>

<h2>데이터 목록</h2>
<table border="2">
	<tr>
		<th>학생 번호</th>
		<th>학생 이름</th>
	</tr>
<%
	for(MemberVO v:mDAO.selectAll(mVO)){
		out.println("<TR>");
		out.println("<TH><A HREF='NewFile1.jsp?mpk="+v.getMpk()+"'>"+v.getMpk()+"</A></TH>");
		out.println("<TD>"+v.getName()+"</TD>");
		out.println("</TR>");
	}
%>
</table>

</body>
</html>