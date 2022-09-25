package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentVO;

public class StudentView {
	public int action;
	Scanner sc = new Scanner(System.in);

	public void startView() {
		while (true) {
			System.out.println();
			System.out.println("===학생부 프로그램===");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생목록");
			System.out.println("3. 성적변경");
			System.out.println("4. 학생삭제");
			System.out.println("5. 종료");
			System.out.println("6. 검색");
			System.out.print("메뉴입력) ");
			try {
				action = sc.nextInt();
				if (1 <= action && action <= 5) {
					break;
				}
				System.out.println("범위외입력!");
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수만 입력하세요!");
			}
		}
	}

	public String inputString() {
		System.out.print("문자열입력) ");
		String str = sc.next();
		return str;
	}

	public int inputInt() {
		System.out.print("정수입력) ");
		int i = sc.nextInt();
		return i;
	}

	public void printDatas(ArrayList<StudentVO> datas) {
		System.out.println();
		if (datas.size() == 0) {
			System.out.println("저장된 정보가 없습니다!");
			return;
		}
		System.out.println("=== 학생목록 ===");
		for (StudentVO vo : datas) {
			System.out.println(vo.getNum() + "번 " + vo.getName() + "학생 " + vo.getScore() + "점");
		}
		System.out.println("==============");
	}

	public void func1() {
		System.out.println("학생추가 메뉴입니다.");
	}

	public void func2() {
		System.out.println("학생목록 메뉴입니다.");
	}

	public void func3() {
		System.out.println("성적변경 메뉴입니다.");
	}

	public void func10() {
		System.out.println("학생삭제 메뉴입니다.");
	}

	public void func4() {
		System.out.println("이름을 입력합니다..");
	}

	public void func5() {
		System.out.println("성적을 입력합니다..");
	}

	public void func6() {
		System.out.println("번호를 입력합니다..");
	}

	public void func7() {
		System.out.println("프로그램을 종료합니다.....");
	}

	public void func8() {
		System.out.println("수행성공!");
	}

	public void func9() {
		System.out.println("수행실패...");
	}

	public String func11() {
		String ans;
		while (true) {
			System.out.println("성적을 추가입력 하시겠습니까?(Y/N)");
			ans = sc.next();
			ans.toUpperCase(); // 대문자로 변경
			if (ans.equals("Y") || ans.equals("N")) {
				break;
			}
			System.out.println("Y or N만 입력 가능합니다!");
		}
		return ans;
	}

	public void func12() {
		System.out.println("학생검색 메뉴입니다.");
	}

}
