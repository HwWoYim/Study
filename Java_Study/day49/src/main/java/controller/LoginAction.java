package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		// 로그인할 때 mname 값을 가져올 게 없다. 그러므로 로깅처리하면 null값이 출력된다.
//		mVO.setMname(request.getParameter("mname"));0
//		System.out.println("LoginAction :20번 라인 manme: " + request.getParameter("mname"));
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			HttpSession session=request.getSession(); // 세션에 저장되어 있는 정보를 가져와야 하니까
			session.setAttribute("uid", mVO.getMid()); // 세선에 로그인 성공한 id저장
			session.setAttribute("mname", mVO.getMname());	// 세션에 로그인 성공한 Mname저장
//			System.out.println("LoginAction :28번 라인 manme → " + session.getAttribute("mname"));
		} else {
			System.out.println("로그 : 로그인 실패");
		}
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true); // 로그인 정보는 세션에 저장된다. forward 방식으로 정보를 기억할 필요 없다.
		return forward;
	}
}
/*
else if(action.equals("login")){
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("mid", mVO.getMid());
			response.sendRedirect("ctrlB.jsp?action=main");
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
	}
*/