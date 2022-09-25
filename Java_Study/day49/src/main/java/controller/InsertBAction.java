package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class InsertBAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		bVO.setMid(request.getParameter("mid"));
		bVO.setMsg(request.getParameter("msg"));
		
		if(bDAO.insert(bVO)) {	// 현재의 cnt를 get하여 다시 request로 set하였다.
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("insert 오류");
		}
		return forward;
	}
}
/*
else if(action.equals("insertB")){
		if(bDAO.insert(bVO)){
			response.sendRedirect("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("insertB 오류");
		}
	}
*/