<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO, java.util.ArrayList"%>
    <jsp:useBean id="mDAO" class="model.dao.MemberDAO"/>
    <jsp:useBean id="mVO" class="model.vo.MemberVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="controller.jsp" method="post">
	이름 : <input type="text" name="name" required>
	점수 : <input type="number" min="0" max="100" name="score" required> <br><br>
	<input type="submit" value="데이터등록하기">
	</form>
<hr>
<h1>데이터 목록</h1>
<hr>
<%
	ArrayList<MemberVO> datas = mDAO.selectAll(mVO);
	if(datas.size()==0){
		out.println("<h3>출력할 데이터가 없습니다...</h3>");
	} else{
%>
<table border="2">
	<tr>
		<th>번호</th><th>이름</th>
	</tr>
	<%
		for(MemberVO v:mDAO.selectAll(mVO)){
			out.println("<TR>");
			out.println("<TH><A HREF='NewFile1.jsp?mpk="+v.getMpk()+"'>"+v.getMpk()+"</A></TH>");
			out.println("<TD>"+v.getName()+"</TD>");
			out.println("<TR>");
		}
	%>
</table>
<%
	}
%>

</body>
</html>