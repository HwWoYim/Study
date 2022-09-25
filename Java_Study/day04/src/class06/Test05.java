package class06;

public class Test05 {
	public static void main(String[] args) {
		
		// 1. 출력 주석
		// 2. 변수 3요소 : 공간, "자료형", 식별자
		// 3. 연산자 우선순위 -> 디버깅표
		// 4. 제어문 : 조건문 / 반복문
		
		// 5. 배열
		
		int stu1 = 80;
		int stu2 = 90;
		int stu3 = 85;
		int[] stu = {80,95,85};	// int를 저장할 배열
		// index : 인덱스 : [0]부터 시작!
		// 배열 3요소
		// 1. 서로 관련된 데이터
		// 2. 서로 동일한 자료형
		// 3. 몇 개인지 분명히 알아야 합니다!
		
		System.out.println("학생1: " + stu[0]);
		System.out.println("학생2: " + stu[1]);
		System.out.println("학생3: " + stu[2]);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("학생" + (i + 1) + ": " + stu[i]);
		}
		// 서로 관련된 데이터를 한 공간에서 관리하면 좋겠다
		
		
		
		
		
		
	}
}
