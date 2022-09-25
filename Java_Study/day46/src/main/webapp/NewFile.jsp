<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>&lt;회원 리스트&gt;</h1>

<table border="1">
   <tr>
      <th>이름</th>
      <th>전화번호</th>
   </tr>
   <%--<c:forEach var="왼쪽- 뭐라고 부를지 변수명 결정" items="어플리케이션 스코프 내장객체에 저장된 datas"> --%>
   <c:forEach var="v" items="${datas}">
   <tr>
      <td>${v.name}</td>
      <%-- out: 무엇을 출력하는 것 --%>
      <td><c:out value="${v.phone}" escapeXml="false"><front color="red">phone 정보없음</front></c:out></td>
   </tr>
   </c:forEach>
</table>

</body>
</html>