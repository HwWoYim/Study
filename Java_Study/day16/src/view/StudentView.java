package view;

import java.util.Scanner;

import model.StudentVO;

// 사용자의 흐름(User Flow)을 설계
public class StudentView {
	private int startNum=1;
	private int endNum=2; // 기능이 추가된다면, 마지막 기능번호로 변경할것!
	public int act; // 사용자의 입력값을 저장할 변수
	public void startView() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("학생부 프로그램입니다.");
			System.out.println("1.이름출력 2.종료");
			System.out.print("입력) ");
			this.act=sc.nextInt();
			if(startNum<=act&&act<=endNum) {
				break;
			}
			System.out.println("번호확인후 다시입력해주세요!");
		}
	}
	public void func1(StudentVO vo) { // 1번누르면 나오는 화면
		System.out.println("학생이름: "+vo.getName());
	}
}