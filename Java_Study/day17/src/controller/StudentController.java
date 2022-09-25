package controller;
import java.util.ArrayList;

import model.StudentDAO;
import model.StudentVO;
import view.StudentView;

public class StudentController {
	private StudentDAO model;
	private StudentView view;
	public StudentController() {
		model=new StudentDAO();
		view=new StudentView();
	}
	public void startApp() {
		while(true) {
			view.startView();
			if(view.action==1) { // ★★★ 학생추가
				view.func1();
				view.func4();
				String name=view.inputString();
				String ans =view.func11();
				int score;
				if(ans.equals("N")) {
					score = 0;
				}
				else {
					view.func5();
					score=view.inputInt();
				}
				StudentVO vo=new StudentVO();
				vo.setName(name); // V에서 입력받은 값을
				vo.setScore(score); // vo객체에 setter로 설정해서 인자로 넘겨줌
				boolean flag=model.insert(vo);
				if(flag) {
					view.func8();
				}
				else {
					view.func9();
				}
			}
			else if(view.action==2) { // ★★★★★ 학생목록
				view.func2();
				StudentVO vo=new StudentVO();
				ArrayList<StudentVO> datas=model.selectAll(vo);
				view.printDatas(datas);
			}
			else if(view.action==3) { //학생변경
				view.func3();
				view.func6();
				int num=view.inputInt();
				view.func5();
				int score=view.inputInt();

				StudentVO vo=new StudentVO();
				vo.setNum(num);
				vo.setScore(score);
				boolean flag=model.update(vo);
				if(flag) {
					view.func8();
				}
				else {
					view.func9();
				}
			}
			else if(view.action==4) { //학생삭제
				view.func10();
				view.func6();
				int num=view.inputInt();

				StudentVO vo=new StudentVO();
				vo.setNum(num);
				vo=model.selectOne(vo);
				if(vo==null) {
					System.out.println("	로그: "+num+"번의 학생은 존재하지않습니다!");
					view.func9();
					continue;
				}

				boolean flag=model.delete(vo);
				if(flag) {
					view.func8();
				}
				else {
					view.func9();
				}
			}
			else if(view.action==5) { //종료
				view.func7();
				break;
			}	
			else if(view.action ==6) { //검색
				view.func12();
				view.func4();
				String name = view.inputString();
				StudentVO vo = new StudentVO();
				vo.setName(name);
				ArrayList<StudentVO> datas = model.selectAll(vo);
				view.printDatas(datas);
			}
		}
	}
}

