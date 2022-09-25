package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardVO;
import board.ReplyVO;
import member.MemberDAO;
import member.MemberVO;

public class DeleteMAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = null;
      // 게시글, 댓글이 있으면 회원탈퇴가 불가하다.
      MemberDAO mdao = new MemberDAO();
      BoardDAO dao = new BoardDAO();
      MemberVO mvo = new MemberVO();
      BoardVO bvo = new BoardVO();
      ReplyVO rvo = new ReplyVO();
      
      // 삭제 조건에 알맞은지 확인하기 위해 mid를 가져옴
      bvo.setMid(request.getParameter("mid"));
      rvo.setMid(request.getParameter("mid"));
      // 삭제 조건에 알맞다면 해당 회원을 삭제해주기 위한 mid,mpw이다.
      mvo.setMid(request.getParameter("mid"));
      mvo.setMpw(request.getParameter("mpw"));
      
//      System.out.println(mvo.getMid());
//      System.out.println(bvo.getMid());
//      System.out.println(rvo.getMid());
      
      if(dao.selectOneB(bvo)==null && dao.selectOneR(rvo)==null ) { // mid의 게시물이 없다면? 그리고 mid의 댓글이 없다면
         if(mdao.delete(mvo)) { // 저장한 정보를 sql에 '?'에 대입
            HttpSession session = request.getSession(); // 세션정보 가져옴
            session.invalidate(); // 회원삭제가 되었으니 세션 삭제
            forward = new ActionForward();
            forward.setPath("main.do");
            forward.setRedirect(true);	// 회원삭제까지 되었으면 기억할게 없으니 redirect로 보낸다.
         }
      }
      else {
         System.out.println("로그 : 탈퇴실패");
         throw new Exception("탈퇴 실패");
      }
//      request.setAttribute("cnt", request.getParameter("cnt"));
      return forward;
   }
}