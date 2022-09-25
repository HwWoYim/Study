package com.kim.biz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("data")
public class BoardController{
	@RequestMapping(value="/board.do")
	public String board(BoardVO bVO, BoardDAO bDAO, Model model) {

		bVO=bDAO.selectOneBoard(bVO);
		model.addAttribute("data", bVO); // boot���
		return "board.jsp";
	}
	//�Խñ� �ۼ�
	@RequestMapping(value="/insertBoard.do")
	public String insertboard(BoardVO bVO, BoardDAO bDAO) {
		bDAO.insertBoard(bVO);
		System.out.println("�Խñ� �߰� �α� : " + bVO);
		return "main.do";
	}
	//�Խñ� ����
	@RequestMapping(value="/updateBoard.do")
	public String updateboard(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO, Model model) {
		bDAO.updateBoard(bVO);
		return "main.do";
	}
	//�Խñ� ����
	@RequestMapping(value="/deleteBoard.do")
	public String deleteboard(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO, Model model) {
		bDAO.deleteBoard(bVO);
		return "main.do";
	}
}
