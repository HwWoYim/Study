<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="border"%>
<%@ attribute name="bgcolor"%>
<%@ attribute name="font-size"%>
<jsp:useBean id="hello" class="test.Practice" />
<h1><jsp:doBody/></h1>
<table border="${border}" bgcolor="${bgcolor}" font-size="${font-size}">
	<%
	for(String v:hello.getDatas()){
		%>
	<tr>
		<td><%=v%></td>
	</tr>
	<%
	}
%>
</table>
