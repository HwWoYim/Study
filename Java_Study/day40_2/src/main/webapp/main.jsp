<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.vo.BoardVO,java.util.ArrayList"%> <!-- BoardVO와 ArrayList를 사용하기 위해 import문 선언 -->
<!-- 자바 코드를 줄이기위해 jsp:useBean사용 -->
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="member" class="model.vo.MemberVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<script type="text/javascript">
   function checkPW(){	// function함수 생성
      ansPW = prompt('비밀번호 입력해주세용');	//ansPW에 prompt입력값 저장
      if(ansPW == '${member.mpw}') {
	<%-- ansPW와 MemberVO가 가지고 있던 Mpw와 동일하다면??? --%>
		document.getElementById('mypagecheck').submit();
	<%-- 문저 전체의  --%>
		// 데이터를 post방식으로 보내주기 위해
				// location.href="controller.jsp?action=mypage"; 노노
				// ansPW와 MemberVO가 동일하지 않다면?
			} else {
				alert('틀렸습니당. 다시 생각하고 적어주세용.'); // 실패 출력문 출력
				return;
			}
		}
	</script>

	<%
	if (member.getMid() != null) { // 로그인 상태라면은?
	%>
	<h1>
		<a href="javascript:checkPW()">"${member.mname}"</a>님, 반갑습니다! :D
	</h1>
	<!-- a태그에 check함수 대입 / 사용자 현재 이름 출력 -->
	<!-- post방식으로 정보를 저장, 받아온다. -->
	<form id="mypagecheck" action="controller.jsp" method="post">
		<!-- 마이페이지일시 hidden으로 -->
		<input type="hidden" name="action" value="mypage"> <input
			type="hidden" name="mid" value="${member.mid}"> <input
			type="hidden" name="mpw" value="${member.mpw}">
			<a href=controller.jsp?action=logout>로그아웃</a> <br> <br>
	</form>
	<%
	} else {
	%>
	<h1>비회원입니다. 로그인 하면 많은 정보를 확인할 수 있습니다.</h1>
	<%
	}
	%>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="action" value="main">
		<table border="3">
			<tr>
				<td><select name="searchCondition">
						<option selected value="TITLE">제목</option>
						<option value="WRITER">작성자</option>
				</select> &nbsp; 
				<input type="text" name="searchContent">&nbsp;&nbsp;&nbsp;
				<input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>
	<br>
	<table border="2">

		<tr>
			<th>번 호</th>
			<th>제 목</th>
			<th>작성자</th>
		</tr>
		<%
		// BoardVO의 v에 ArrayList의 datas 배열정보들을 반복하여 저장한다.
		for (BoardVO v : (ArrayList<BoardVO>) datas) {
		%>
		<tr>
		<!-- v.getBid를 누르면 controller의jsp action이 board와 bid가 현재Bid값인 번호로 이동시켜줘를 수행하게 된다. -->
			<th><a href="controller.jsp?action=board&bid=<%=v.getBid()%>"><%=v.getBid()%></a></th>
			<!-- 제목출력 -->
			<td><%=v.getTitle()%></td>
			<%
			if (member.getMname() == null) { // 만약(member의 getMname()이 null값이라면)
			%>
			<td><a>비밀작성자</a></td> <!-- 비밀작성자라고 출력해줘 -->
			<%
			} else {	// 아니라면
			%>
			<td><%=v.getWriter()%></td> <!-- 이름으로 출력해줘 -->
		</tr>
		<%
		}
		}
		%>
	</table>
	<%
	if (member.getMid() != null) { //만약(member의 getMid()가 null값이 아니라면) == 로그인되었다면
	%>
	<hr>
	<a href="form.jsp">새로운 글 작성하기</a> 
	<%
	} else { // 아니라면 == 로그인 되지 않은 상태라면
	%>
	<a href="login.jsp">로그인</a>
	<a href="sign.jsp">회원가입</a>
	<%
}
%>
</body>
</html>