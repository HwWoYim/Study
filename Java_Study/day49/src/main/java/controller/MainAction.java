package controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;
import member.MemberDAO;
import member.MemberVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//   request.setCharacterEncoding("UTF-8");//인코딩 필터가 없으면 이작업을 해야함 
		//   response.setCharacterEncoding("UTF-8"); //인코딩 필터가 없으면 이작업을 해야함 

		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();


		String paramCnt = request.getParameter("cnt");
		if(paramCnt == null || paramCnt.equals("")){ // 첫 메인화면 게시글 2개 표현
			bvo.setCnt(2); // 향후 초기화 매개변수 등으로 설정가능
		}
		else { // 해당 로직이 없다면 글이 아에 없는 상태에서  글 작성을 하게 되면 cnt가 전달되지 않음
			bvo.setCnt(Integer.parseInt(paramCnt));
		}
		// 최근 가입한 3명 -> 배열에 저장
		ArrayList<MemberVO> member = mdao.selectThree(mvo);
		// member변수를 member속성 값으로 저장
		request.setAttribute("member", member);


		// main.jsp에서 로그인된 id로 셋팅된 showContent를 가져옴.
		String showContent = request.getParameter("showContent");
		System.out.println("showContent : [" + showContent + "]");

		HttpSession session = request.getSession(); // 출력할 게시글의 작성자를 세션에 저장 
		if(showContent != null) { // 메인으로 가기 / 내가 쓴 글 보기 / 최근 가입 회원이 쓴 글에 접속
			if(showContent.equals("main")) { // 메인이동
				session.removeAttribute("moreContent"); // 세션 삭제 --> 전체 글 보기
			}
			else { // 내가 쓴 글 / 최근 회원이 쓴 글
				session.setAttribute("moreContent", showContent); // 작성자 세션 저장
				bvo.setMid(showContent); // 해당 작성자의 모든 게시글 출력하기 위한 mid set
			}
		}
		else { // 작성, 삭제, 좋아요 등 게시글 조작 --> showContent를 전달하지 않는다.
			// 그래서 세션에 있는 작성자 정보 이용
			// ex) 내가 쓴 글 보기(나의 mid 세션에 저장) --> 좋아요, 댓글 등 기능 수행(showContent 전달 X) 
			bvo.setMid((String)session.getAttribute("moreContent")); // 바로 직전에 세션에 저장된 작성자의 글을 출력(전체 게시글 포함)
		}			

		ArrayList<BoardSet> datas = bdao.selectAll(bvo); // bid를 내림차순한 게시글 목록
		request.setAttribute("datas", datas); // 현재페이지는 forward 방식으로 보내므로 다음까지 기억
		request.setAttribute("cnt", bvo.getCnt()); // 윗줄과 동일

		
		// 모든 게시글 보면 더보기 버튼 비활성화
		BoardVO nextBvo = bvo;
		// 현재 bvo 정보를 담은 nextBvo는 다음에 보여줄 게시글 2개를 미리 계산하여 저장한다.
		nextBvo.setCnt(bvo.getCnt() + 2);
		// 다음 더보기 눌렀을 때의 게시물들을 저장하는 배열.
		ArrayList<BoardSet> nextDatas = bdao.selectAll(nextBvo);
		// cnt와 '다음에 보여줄 게시글 개수' 차이가 2보다 크거나 같으면 더보기 버튼 비활성화
		request.setAttribute("noMoreContent", nextBvo.getCnt() - nextDatas.size() >= 2 ? true : false);


		ActionForward forward = new ActionForward();
		forward.setPath("/main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}