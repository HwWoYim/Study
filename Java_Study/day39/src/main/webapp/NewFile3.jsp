<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mDAO" class="model.dao.MemberDAO" />
<jsp:useBean id="mVO" class="model.vo.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<%
	if(mDAO.delete(mVO)){
		%>
		<script type="text/javascript">
			alert('<%=mVO.getMpk()%>번 데이터 삭제 완료!');
			location.href="NewFile.jsp";
		</script>
		<%
	}
	else{
	%>
		<script type="text/javascript">
			alert('데이터 삭제에 문제가 발생했습니다...');
			location.href="NewFile.jsp";
		</script>
	<%
	}
%>