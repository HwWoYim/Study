package class03;

import java.util.Random;

//모듈화
public class Test01 {
	
	static void print(boolean flag) {	// 함수의 기능을 유추할 수 있게 작성
		// 변수 3요소 : 1.공간의 크기 2.자료형 3.공간의 주소->식별자(이름)
		// 배열 3요소 : 1.서로 관련된 데이터 2.같은 자료형 3.갯수를 분명히 알고 있어야 함
		// 함수 3요소 : 1.input 2.output 3.기능
		// 메소드 시그니쳐 : void print(boolean flag)
		if(flag) {	// True일때 짝수이다
		System.out.println("짝수!");
		} else {
			System.out.println("홀수!");
		}
	}
	static boolean ch(int num) {
		// 정수로 입력 받으면 T,F로 변경
		if(num%2==0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		print(true);
		
		// 어떤 로직을 "함수화"
		// -> 코드의 재사용성이 증가
		// -> 중복코드 최소화
		// -> 오류의 파급효과 줄어듦
		// => "유지보수" 용이

		Random rand=new Random();
		int[] data=new int[5];
		for(int i=0;i<data.length;i++) {
			data[i]=rand.nextInt(100)+1;
		}
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		for(int i=0;i<data.length;i++) {
			 print(  ch(data[i]) );

		}



	}
}
