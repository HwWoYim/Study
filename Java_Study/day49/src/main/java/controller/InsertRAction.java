package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class InsertRAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		ReplyVO rVO = new ReplyVO();
		BoardDAO bDAO = new BoardDAO();
		
		// BoardDAO로 넘겨줄 정보들을 전 페이지에서 가져와서 ReplyVO에 저장한다.
		rVO.setMid(request.getParameter("mid"));
		rVO.setBid(Integer.parseInt(request.getParameter("bid"))); //request로 가져온 값은 object이기 때문에 형변환 후에 셋팅
		rVO.setRmsg(request.getParameter("rmsg"));
		
//		request.setAttribute("afterReply", true);
		
		if(bDAO.insertR(rVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false); // 댓글을 작성하고 더보기 상태를 기억하기 위해 forward로 보낸다.
		} else {
			throw new Exception("insetR 오류");
		}
		return forward;
	}
}
/*
else if(action.equals("insertR")){
		if(bDAO.insertR(rVO)){
			pageContext.forward("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("insertR 오류");
		}
	}
*/