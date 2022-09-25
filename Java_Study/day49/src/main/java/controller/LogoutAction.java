package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(); // 세션 확보
		session.invalidate(); // 세션 정보 삭제
		
		ActionForward forward=new ActionForward();
		//ActionForward 객체생성되면 2가지 정보를 저장할 수 있음 =>setPath(), setRedirect()
		//ActionForward 객체를 생성한다고 해서 바로 페이지이동이 가능하지않다. 이 객체는 이동할 정보만 가지고 있다.
		forward.setPath("main.do"); // 메인으로 이동
		forward.setRedirect(true);	// 정보를 기억하지 않고 redirect로 전송 
		return forward;
	}

}
