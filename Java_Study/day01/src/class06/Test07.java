package class06;

public class Test07 {

	public static void main(String[] args) {

		// 코드를 컴퓨터가 실행할 수 있는 형태로 번역해주는 친구 : 컴파일러
		int a = (int)3.14;	// 형변환(타입 캐스팅) : 명시적 형변환
			// 출력하면 3이 출력되고 뒤에 소수점아래는 아예 손실된다.
			// 데이터 손실 발생여지가 있다.
		
		double b = 5;	// 자동 형변환
		// 메모리 낭비가 너무 심하다
		
		
		System.out.println(a);
		System.out.println(b);
	}

}
