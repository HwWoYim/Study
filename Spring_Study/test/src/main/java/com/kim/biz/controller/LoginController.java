//package com.kim.biz.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.kim.biz.member.MemberVO;
//import com.kim.biz.member.impl.MemberDAO;
//
///*
//package com.kim.biz.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public interface Controller {
//	String handleRequest(HttpServletRequest request, HttpServletResponse response);
//}
// */
//@Controller
//public class LoginController {
//	
//	@RequestMapping("/login.do") // �� �̻� ��� �޴°� ���� ������ @override���� �ʴ´�.
//	public ModelAndView handleRequest(HttpServletRequest request) {
//		MemberVO mVO=new MemberVO();
//		mVO.setMid(request.getParameter("mid"));
//		mVO.setMpw(request.getParameter("mpw"));
//
//		MemberDAO mDAO=new MemberDAO();
//		mVO=mDAO.selectOneMember(mVO);
//
//		// ������
//		// ��ȯ�ؾ��� Ÿ�� : mav(ModelAndView)
//		// ModelAndView ��ü ���ο��� viewName�̶�� ��������� �����Ѵ�.
//			// �� �װ��� ���� �����ϴ��� ������ ���ش�. 
//		ModelAndView mav=new ModelAndView();
//		if(mVO==null) {
//			mav.setViewName("redirect:login.jsp");
//		}
//		else {
//			HttpSession session=request.getSession();
//			session.setAttribute("member", mVO);
//
//			mav.setViewName("redirect:main.do");
//		}
//		return mav;
//	}
//	 
//	/*
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		String mid=request.getParameter("mid");
//		String mpw=request.getParameter("mpw");
//		MemberVO mVO=new MemberVO();
//		mVO.setMid(mid);
//		mVO.setMpw(mpw);
//
//		MemberDAO mDAO=new MemberDAO();
//		mVO=mDAO.selectOneMember(mVO);
//
//		if(mVO==null) {
//			return "login"; // VR�� .jsp�� �߰��ϱ⶧���� �����ؼ� ��ȯ
//		}
//		else {
//			HttpSession session=request.getSession();
//			session.setAttribute("member", mVO);
//
//			return "main.do";
//		}
//	}
//	 */
//
//}
