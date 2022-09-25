<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="mDAO" class="model.dao.MemberDAO"/>
    <jsp:useBean id="mVO" class="model.vo.MemberVO"/>
    <jsp:setProperty property="*" name="mVO"/>
    <%
    mVO=mDAO.selectOne(mVO);
    if(mVO==null){
    	response.sendRedirect("NewFile.jsp");
    } else{
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><%=mVO.getName()%>학생 정보</h1>
<form action="NewFile2.jsp" method="post">
<table border="2">
	<tr>
		<td>학번</td>
		<td><input type="text" name="mpk" value="<%=mVO.getMpk()%>" readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="<%=mVO.getName()%>"></td>
	</tr>
	<tr>
		<td>점수</td>
		<td><input type="number" name="score" min="0" max="100" value="<%=mVO.getScore()%>"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="변경">&nbsp;<input type="button" id="btn" onclick="del(<%=mVO.getMpk()%>);" value="삭제">&nbsp;<input type="button" id="cancel" onclick="location.href='NewFile.jsp'" value="취소">
		</td>
	</tr>
</table>
</form>
<!-- 
<script type="text.javascript">
	function del(mpk){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="NewFile3.jsp?mpk="+mpk;
	} else{
		return false;
		}
	}
</script>
 -->
<%
    }
%>

</body>
</html>