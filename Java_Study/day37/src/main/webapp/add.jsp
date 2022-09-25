<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니에 물건을 추가하는 로직(화면출력xxx)</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String product=request.getParameter("product");
	
	ArrayList<String> datas=(ArrayList)session.getAttribute("datas");
	// session에 저장된 장바구니를 불러오는 코드
	if(datas==null){ // 장바구니가 생성되지않은 경우
		datas=new ArrayList<String>();
		session.setAttribute("datas", datas);
	}
	datas.add(product);
%>
<script type="text/javascript">
	alert("<%=product%>이(가) 장바구니에 추가되었습니다!");
	history.go(-1);
</script>

</body>
</html>