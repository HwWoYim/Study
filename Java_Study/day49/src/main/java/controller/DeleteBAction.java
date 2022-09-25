package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class DeleteBAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;	// 경로, 방식 null값으로 일단 초기화
		
		BoardVO bVO = new BoardVO(); // bid, mid, msg, favcnt, rcnt, cnt
		BoardDAO bDAO = new BoardDAO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid"))); // 받아온 타입이 object이기 때문에 정수타입으로 형변환 후에 셋팅.
		
		if(bDAO.delete(bVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");	// main으로 이동
			forward.setRedirect(false);	// forward방식
		} else {
			throw new Exception("DeleteB 오류");
		}
		return forward;
	}
}
/*
else if(action.equals("deleteB")){
		if(bDAO.delete(bVO)){
			response.sendRedirect("ctrlB.jsp?action=main");
		}
		else{
			throw new Exception("deleteB 오류");
		}
	}
*/