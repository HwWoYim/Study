package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class FavAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		if(bDAO.update(bVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("fav 오류");
		}
		return forward;
	}	
}
/*
else if(action.equals("fav")){
		if(bDAO.update(bVO)){
			pageContext.forward("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("fav 오류");
		}
	}
*/