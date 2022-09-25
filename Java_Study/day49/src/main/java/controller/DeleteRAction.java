package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class DeleteRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		ReplyVO rVO = new ReplyVO();
		BoardDAO bDAO = new BoardDAO();
		// main.jsp -> reply.tag -> 가져온 rid를 새로운 ReplyVO객체에 저장.
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));

		if(bDAO.deleteR(rVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);	// reply를 삭제 하면 더보기 누른 값을 기억해야 하니까 forward인가???
		} else {
			throw new Exception("DeleteR 오류");
		}
		return forward;
	}
}
/*
else if(action.equals("deleteR")){
		if(bDAO.deleteR(rVO)){
			pageContext.forward("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("deleteR 오류");
		}
	}
 */