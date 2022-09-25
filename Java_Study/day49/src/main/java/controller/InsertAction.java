package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class InsertAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = null;

		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		// PrintWriter는 new로 초기화하지 않고 사용. : 자바에서 웹으로 데이터를 출력하기 위해 사용
		PrintWriter out = response.getWriter();
		// 전 페이지에서 정보를 가져와서 MemberVO에 셋팅
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setMname(request.getParameter("mname"));

		// 유효성 검사하자. 왜 안되는걸까 ★★★★★★★★★★★★★★★★★★★★★★★★★
		if(mDAO.insert(mVO)) {
			forward = new ActionForward();
			out.println("<script>alert('회원가입 완료!');opener.parent.location.reload();window.close();</script>");
			forward.setPath("main.do");
			forward.setRedirect(true);
		}else{
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		return forward;
	}

}
/*
 *if(action.equals("insert")){
		if(mDAO.insert(mVO)){
			out.println("<script>alert('회원가입 완료!');opener.parent.location.reload();window.close();</script>");
		}
		else{
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
	} 
 */
