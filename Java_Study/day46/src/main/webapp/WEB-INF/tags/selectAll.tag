<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1><jsp:doBody /></h1>

<c:forEach var="v" items="${datas}">
	<tr>
		<th><a href="controller.jsp?action=board&bid=${v.bid}">${v.bid}</a></th>
		<td>${v.title}</td>
		<td>${v.writer}</td>
		<td>${v.bread}</td>
		<td>${v.blike}</td>
		<td>${v.bdate}</td>
	</tr>
</c:forEach>