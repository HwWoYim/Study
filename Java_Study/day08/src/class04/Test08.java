package class04;

import java.util.Iterator;
import java.util.Scanner;

class Student{
	String name;
	int score;
	void showInfo() {
		System.out.println(name + "학생은 " + score + "점 입니다.");
	}
	Student(String name, int score){
		this.name=name;
		this.score=score;
		System.out.println(this.name+"학생 입력완료!");

	}
}


public class Test08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Student[] data = new Student[3];
		int index = 0;
		
		while(true) {
			System.out.println("1. 추가");
			System.out.println("2. 출력");
			System.out.println("3. 변경");
			System.out.println("4. 종료");
			System.out.print("입력 >>> ");
			int act = sc.nextInt();
			// 사용자가 입력하면 -> 유효성 검사 꼭 해줘야 합니다!
			
			if(act==1) {
				if(index == data.length) {
					System.out.println("데이터 공간이 부족합니다!!!!");
					continue;
				}
				System.out.print("학생이름 입력: ");
				String name = sc.next();
				System.out.print("학생성적 입력: ");
				int score=sc.nextInt();
				
				data[index] = new Student(name, score);
				index++;
			}else if(act==2) {
				if(index==0) {
					System.out.println("저장한 정보가 없습니다!!");
					continue;
				}
				System.out.println("===학생목록===");
				 for (int i = 0; i < index; i++) {
					data[i].showInfo();
				}
			}else if(act==3) {
				System.out.print("정보를 변경할 학생의 번호 입력>>> ");
				int num = sc.nextInt();
				num--;	// 실제 번호와 인덱스번호의 차이
				if(num<0 || index<=index) {
					System.out.println("없는 번호입니다! 확인 후 다시 이용해주세요!!");
					continue;
				}
				System.out.print("변경할 점수 입력>>> ");
				data[num].score=sc.nextInt();
				System.out.println(data[num].name + "학생 정보 변경완료!");
				
			}else if(act==4){
				System.out.println("종료됩니다...");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
		
	}
}
