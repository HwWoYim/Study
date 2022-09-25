<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp" import="java.util.ArrayList,model.vo.*" %>	<%-- 파일의 속성과 import문 표현 --%>
<%
	request.setCharacterEncoding("UTF-8");	// 인코딩
%>
<jsp:useBean id="mDAO" class="model.dao.MemberDAO" />	<!-- MemberDAO mDAO = new MemberDAO -->
<jsp:useBean id="bDAO" class="model.dao.BoardDAO" />	<!-- BoardDAO bDAO = new BoardDAO -->
<jsp:useBean id="bVO" class="model.vo.BoardVO" />	<!-- BoardVO bVO = new BoardVO -->
<jsp:setProperty property="*" name="bVO" />	<!-- bVO의 모든 프로퍼티를 자동 맵핑 -->
<jsp:useBean id="mVO" class="model.vo.MemberVO" />	<!-- MemberVO mVO = new MemberVO -->
<jsp:setProperty property="*" name="mVO" />	<!-- mVO의 모든 프로터티를 자동 맵핑 -->
<%
	// 어떤 요청을 받았는지 파악
	//  -> 해당 요청을 수행

	String action=request.getParameter("action");	// "action"을 끌어와서 action에 대입
	System.out.println("로그: "+action);	// 현재 action을 로그로 출력
	
	if(action.equals("login")){	// action이 로그인이라면?
		MemberVO member=mDAO.selectOne(mVO);	// 
		if(member!=null){	// member 존재 한다면
			session.setAttribute("member", member);	// 오른쪽member를 왼쪽"member"에 저장!
			response.sendRedirect("controller.jsp?action=main");	// action을 main으로 브라우저 실행
		}
		else{
			response.sendRedirect("login.jsp");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	else if(action.equals("sign")){
		if(mDAO.insert(mVO)){
			response.sendRedirect("login.jsp");
		}
		else{
			throw new Exception("sign 오류");
		}
	}
	else if(action.equals("mypage")){
		//MemberVO member=(MemberVO)session.getAttribute("member");
		// session으로 받을경우 모든 보안적 데이터가 저장되어있음
		// 많은 데이터가 있으므로 프로그램이 무거워짐
		// 이후에는 selectOne을 통해서 data를 받게될예정
		MemberVO member = mDAO.selectOne(mVO);
		if(member!=null){
			request.setAttribute("data", member);
			pageContext.forward("mypage.jsp");
		}
		else{
			throw new Exception("mypage 오류");
		}
	}
	else if(action.equals("mupdate")){
		if(mDAO.update(mVO)){
			session.invalidate(); // 세션 정보 전체 제거하기
			 /// session.removeAttribute("member");
			response.sendRedirect("login.jsp");
		}
		else{
			throw new Exception("mupdate 오류");
		}
	}
	else if(action.equals("mdelete")){
		MemberVO member=(MemberVO)session.getAttribute("member");
		if(member!=null && mDAO.delete(member)){
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		else{
			throw new Exception("mdelete 오류");
		}
	}
	else if(action.equals("main")){
		ArrayList<BoardVO> datas=bDAO.selectAll(bVO);
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp"); // forward 액션
	}
	else if(action.equals("board")){
		// url상 bid초과해서 입력하면 main으로 가게끔한다.
		// 문자로 입력시 애초에 정수타입으로 받는 것이기 때문에 에러페이지로 이동한다.
		BoardVO data=bDAO.selectOne(bVO);
		if(data==null){
			response.sendRedirect("controller.jsp?action=main");
		}
		request.setAttribute("data", data);
		pageContext.forward("board.jsp");
	}
	else if(action.equals("insert")){
		if(bDAO.insert(bVO)){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			throw new Exception("insert 오류");
		}
	}
	else if(action.equals("update")){
		if(bDAO.update(bVO)){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			throw new Exception("update 오류");
		}
	}
	else if(action.equals("delete")){
		if(bDAO.delete(bVO)){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			throw new Exception("delete 오류");
		}
	}
	else{
		out.println("<script>alert('action 파라미터 값이 올바르지 않습니다...');location.href='controller.jsp?action=main'</script>");	
	}
%>