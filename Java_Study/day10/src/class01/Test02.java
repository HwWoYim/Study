package class01;

import java.util.Scanner;

class Student {
	String name;
	int score;

	void showInfo() {
		System.out.println(this.name + " " + this.score);
	}

	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(this.name + "학생 입력완료!");
	}

}

public class Test02 {

	public static void main(String[] args) {
		// 학생부 프로그램
		// 학생 정보를 배열에 저장해서 관리하는 프로그램

		// 핵심 로직
		// 비즈니스 메서드
		// CRUD
		Student[] data = new Student[3];
		// 최대크기: data.length
		int index = 0; // 현재 저장된 학생수
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.생성 2.출력 3.변경 4.삭제 5.종료");
			int act = sc.nextInt();
			if (act == 1) {
				if (index == data.length) {
					System.out.println("데이터공간이 부족!");
					continue;
				}
				System.out.print("학생이름 입력: ");
				String name = sc.next();
				System.out.print("학생성적 입력: ");
				int score = sc.nextInt();
				data[index] = new Student(name, score);
				index++;
			} else if (act == 2) {
				if (index == 0) {
					System.out.println("저장한 정보가 없습니다!");
					continue;
				}
				System.out.println("===학생목록===");
				for (int i = 0; i < index; i++) {
					data[i].showInfo();
				}

			} else if (act == 3) {
				if (index == 0) {
					System.out.println("저장한 정보가 없습니다!");
					continue;
				}
				System.out.print("정보를 변경할 학생의 번호입력: ");
				int num = sc.nextInt();
				num--; // 번호와 인덱스넘버의 차이
				if (num < 0 || index <= num) { // 유효성 검사
					System.out.println("없는 번호입니다! 확인후 다시이용해주세요~~");
					continue;
				}
				System.out.print("변경할 점수입력: ");
				data[num].score = sc.nextInt();
				System.out.println(data[num].name + "학생 정보 변경완료!");
			} else if (act == 4) {
				if(index==0) {
					System.out.println("삭제할 데이터가 없습니다!");
					continue;
				}
				System.out.println("최근 데이터 삭제중...");
				index--;
				System.out.println("삭제 완료!");
			} else if (act == 5) {
				System.out.println("종료합니다...");
				break;
			} else {
				System.out.println("잘못된 입력입니다!");
			}
		}
	}

}