package class07;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Student{
	Random rd = new Random();
	String name;
	int score;
	
	Student(String name){
		this.name = name;
		this.score = rd.nextInt(100)+1;
	}

	@Override
	public String toString() {
		return this.name + " " + this.score + "점";
	}
	
	
}
public class Test08{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
		int check = 1001;	// 1001부터 입력 받기 위한 변수
		int num;		// 입력 받고 저장할 변수
		String name = null;
		while(true) {
			System.out.println("전자학생부\n1.학생추가 2.학생정보출력 3.학생정보삭제 4.종료");
			System.out.print("번호 입력>>> ");
			int pick = sc.nextInt();	// 메뉴 선택 지점
			if(pick==1) {	// 1을 선택했다면
				System.out.print("이름을 입력하세요>>> ");
				name = sc.next();
				hm.put(check, new Student(name));	// hm 에 check변수와 Student객체의 name을 입력넣는다.
				System.out.println(check + "번째에 저장완료");
				System.out.println(new Student(name));
				check++;
			} else if(pick==2) {	// 2를 선택했다면
				if(hm.size()==0) {	// 저장된 Map의 갯수가 0개라면
					System.out.println("등록된 학생이 없습니다.");
					continue;
				}
				System.out.println("정보를 출력하실 학생 번호를 입력하세요>>> ");
				num = sc.nextInt();
				if(hm.get(num)==null) {	// hm의 num이 아무 값이 없다면
					System.out.println("출력할 정보가 없습니다.");
				}else {
					System.out.println(hm);
				}
			} else if(pick==3) {	// 3을 선택했다면
				if(hm.size()==0) {	// 저장된 Map의 갯수가 0개라면
					System.out.println("삭제할 학생이 없습니다.");
					continue;
				}
				System.out.print("학생정보를 삭제할 학생번호를 입력하세요>>> ");
				num = sc.nextInt();
				hm.remove(num);
				if(hm.get(num)==null) {
					System.out.println("삭제할 정보가 없습니다.");
				} else {
					System.out.println("해당 번호의 학생정보가 삭제되었습니다.");
				}
			} else if(pick==4){	// 4를 선택했다면
				System.out.println("전자학생부 프로그램을 종료합니다.");
				break;
			} else {	// 1,2,3,4도 아니라면
				System.out.println("인식할 수 없는 번호입니다.");
				continue;
			}
		}
		
	}
}
