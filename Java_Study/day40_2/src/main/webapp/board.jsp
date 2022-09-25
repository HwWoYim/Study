<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="data" class="model.vo.BoardVO" scope="request" />
<jsp:useBean id="member" class="model.vo.MemberVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
<script type="text/javascript">
	function del(){
		ans=confirm('정말 삭제할까요?');
		if(ans==true){	// 만약 값이 동일하다면
			// 해당 문서 전체에서 bForm의 action의 value값을 delete로 바꾸어 줘라.
			document.bForm.action.value="delete";
			// 해당 문서 전체에서 bForm의 submit을 수행해줘라.
			document.bForm.submit();
		}
		else{
			return;
		}
	}
</script>

<form name="bForm" action="controller.jsp" method="post">
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="bid" value="${data.bid}">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${data.title}" required></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="${data.content}" required></td>
		</tr>
		<tr>
			<td>작성자</td>
			<!-- readonly로 읽기 기능만 설정한다. -->
			<td><input type="text" name="writer" value="${data.writer}" required readonly></td>
		</tr>
		<c:if test="${member.role=='ADMIN' or member.mname==data.writer}">
		</c:if>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="변경하기">&nbsp;<input type="button" value="삭제하기" onClick="del()">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="javascript:history.go(-1);">돌아가기</a>

</body>
</html>