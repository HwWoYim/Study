<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mDAO" class="model.dao.MemberDAO" />
<jsp:useBean id="mVO" class="model.vo.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<%
	if(mDAO.insert(mVO)){
		%>
	<script type="text/javascript">
		alert('<%=request.getParameter("name")%> 데이터 등록 성공!');
		location.href="NewFile.jsp";
	</script>
		<%
	}
	else{
		%>
	<script type="text/javascript">
		alert('데이터 등록 실패...');
		location.href="NewFile.jsp";
	</script>
		<%	
	}
%>