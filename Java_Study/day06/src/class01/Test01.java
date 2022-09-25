package class01;

public class Test01 {
	
	// static : "객체와 무관하게"
	static void func() {	// 선언, 정의만 한 영역
		System.out.println("내가 만든 첫 번째 함수");
	}
	// 코드의 재사용성이 증가됨
	// 오류의 파급효과가 줄어듦
	// 유지보수 용이
	
	
	public static void main(String[] args) {
		
		// 변수 3요소
		// 공간, 자료형, 식별자
		// 값xxx -> 초기화 이슈
		// 타입캐스팅
		// String
		// Scanner sc = new Scanner(System.in); -> 버퍼
		// 연산자 -> 우선순위
		// 제어문 : 조건문(선택적) / 반복문 -> while(무한루프)+종료조건 / 중첩 반복문(디버깅표)
		// 자료구조 : 배열
		// 알고리즘 : 교환, 정렬->탐색, 최대값 찾기, flag
		
		// [함수]
		int num = 4;
		double num2 = 3.14;
		func();	// 호출(사용)
		System.out.println("메인 함수 공간");
		
	}
}
