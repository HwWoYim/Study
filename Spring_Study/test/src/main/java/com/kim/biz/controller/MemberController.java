package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {
	// �α��� ȭ���� �����ִ� ����
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}

	// �α��� ���ִ� ����
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String selectOneMember(MemberVO mVO, MemberDAO mDAO, Model model, HttpSession session) {
		System.out.println("post����� memberC ���");
		mVO = mDAO.selectOneMember(mVO);
		session.setAttribute("userId", mVO);
		System.out.println("MemberController_login_31_login : " + mVO); // �α�
		if (mVO == null) { // �α��� ����
			return "main.jsp";
		} else { // �α��� ����	
			System.out.println("MemberController_login_35_login : " + mVO); // �α�
			session.setAttribute("member", mVO);	
			return "main.do";
		}
	}

	// �α׾ƿ�
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}

	// ȸ������
	@RequestMapping(value = "/signin.do")
	public String signin(MemberVO mVO, MemberDAO mDAO) {
		mDAO.insertMember(mVO);
		return "login.jsp";
	}

	// ȸ��Ż��
	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(@ModelAttribute("member") MemberVO mVO, MemberDAO mDAO, HttpSession session) {
		// mVO = (MemberVO)session.getAttribute("userId");
		mDAO.deleteMember(mVO);
		return "login.do";
	}

}
