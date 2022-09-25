<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<form action="controller.jsp?action=sign" method="post">
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
			<td>이름</td>
			<!-- required로 필수 값 설정. -->
			<td><input type="text" name="mname" required></td>
		</tr>
		<tr>
			<td>계정권한</td>
			<td>
				<select name="role">
				<!-- selected로 MEMBER을 기본 값으로 설정 -->
					<option selected>MEMBER</option>
					<option>ADMIN</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="login.jsp">돌아가기</a>

</body>
</html>