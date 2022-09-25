<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>

<form action="controller.jsp?action=login" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<!-- required로 필수 값 설정. -->
			<td><input type="text" name="mid" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<!-- required로 필수 값 설정. -->
			<td><input type="password" name="mpw" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<!-- form에서 입력한 데이터 모두 submit으로 인해 login으로 post방식으로 전송 -->
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="index.jsp">처음화면으로</a>
<a href="sign.jsp">회원가입하기</a>

</body>
</html>