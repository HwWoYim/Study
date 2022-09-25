<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="b1" class="vo.Bank1" />
<jsp:useBean id="b2" class="vo.Bank2" />
<jsp:useBean id="dao1" class="dao.Bank1DAO" />
<jsp:useBean id="dao2" class="dao.Bank2DAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

신한: ${b1.bname} | ${b1.balance}원 <br>
국민: ${b2.bname} | ${b2.balance}원

<hr>

<form method="post" acton="NewFile.jsp">
	이체할 금액: <input type="number" value="0" min="0" name="balance">원
	<input type="submit" value="계좌이체">
</form>

</body>
</html>