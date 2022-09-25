<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="model.vo.MemberVO" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

</head>
<body>
<%
 String strReferer = request.getHeader("referer"); //이전 URL 가져오기
 
 if(strReferer == null){
%>
<script language="javascript">
  alert("URL을 직접 입력해서 접근하셨습니다.\n정상적인 경로를 통해 다시 접근해 주세요.");
  history.forward();
 </script>
<%
  return;
 }
%>
<form action="controller.jsp?action=mupdate" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<!-- 읽기만 가능, 수정 불가능 -->
			<td><input type="text" name="mid" value="${data.mid}" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<!-- 필수값 -->
			<td><input type="password" name="mpw" value="${data.mpw}" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<!-- 필수값 -->
			<td><input type="text" name="mname" value="${data.mname}" required></td>
		</tr>
		<tr>
			<td>계정권한</td>
			<td>${data.role}</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="회원정보변경">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="controller.jsp?action=main">메인으로 돌아가기</a> <br>
<a href="controller.jsp?action=mdelete">회원탈퇴</a>

</body>
</html>