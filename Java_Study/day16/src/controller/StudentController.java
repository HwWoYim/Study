package controller;

import model.StudentVO;
import view.StudentView;

public class StudentController {
	StudentVO model;
	StudentView view;

	public void startController() {
		// 프로그램을 처음 수행
		// -> 수행에 필요한 리소스(자원)를 메모리에 적재(load)
		view = new StudentView();
		model = new StudentVO();
		
		model.startModel(); // DB에서 데이터 가져오기
	}
	
	public void startApp() {
		while(true) {
			view.startView();
			
			if(view.act==1) {
				view.func1(model);
				// DB의 데이터를 V파트로 옮기는것(인자로 전달하는것)은,
				// C의 몫이다!
			}
			else if(view.act==2) {
				break;
			}
		}
	}
}
