package test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.yim.biz.board.BoardService;
import com.yim.biz.board.BoardVO;
import com.yim.biz.member.MemberService;
import com.yim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring �����̳ʸ� ���۽�ų���ֵ��� �ڵ��ۼ�
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		Scanner sc=new Scanner(System.in);
		/*
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		System.out.print("�����ۼ� >> ");
		String msg=sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("�� ����");
		vo.setWriter("���� Ƽ��");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		*/
		MemberService ms=(MemberService)factory.getBean("memberService"); // Lookup == �޸𸮿��� ��ü�� "ã��" ��û
		
		System.out.print("���̵� >> ");
		String mid=sc.next();
		System.out.print("��й�ȣ >> ");
		String mpw=sc.next();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo=ms.selectOneMember(mvo); // �ٽɷ����� �����Ϸ����Ѵ�!
		if(mvo==null) {
			System.out.println("�α��� ����...");
		}
		else {
			System.out.println(mvo.getName()+"��, �ȳ��ϼ���! :D");
		}

		factory.close();
		
	}
}
