<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
	<!-- 1. Oracle, JDK11, Tomcat9.0 -->
	<!-- 2. 에러페이지 생성완료, controller지정 -->
	<!-- 3. 표지 페이지는 해당 index.jsp입니다. -->
	<!-- 4. MVC패턴 분리완료 -->
	<!-- 5. 한글데이터 처리 controller를 모두 거치므로 해당 jsp에 저장-->
	<!-- 6. 자바빈즈 활용 -->
	<!-- 7. 로깅처리 PDF로 업로드 -->
	
	

<%
	//response.sendRedirect("controller.jsp?action=main");
	pageContext.forward("controller.jsp?action=main");
	// 페이지 이동에도 값을 유지하게끔 forward 요청
%> 