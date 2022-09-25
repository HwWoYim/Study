<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	<%-- page디렉티브 : 페이지설정 값을 표현 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>

<!-- form태그 액션으로 가고자 하는 URL을 명시적으로 표현. POST방식으로 -->
<!-- form태그 액션은 쿼리 스트링이다. action이 값이고 login이 키값이다. -->
<form action="controller.jsp?action=login" method="post"> 
	<table border="1">
		<tr>
			<td>아이디</td>	
			<td><input type="text" name="mid" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="reg.jsp">회원가입하기</a>

</body>
</html>
<!-- form태그의 데이터들이 input의 submit버튼을 만나 클릭이 되면 
form태그 action에 명시된 url로 post방식으로 데이터가 전송된다. -->