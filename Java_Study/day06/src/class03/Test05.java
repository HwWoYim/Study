package class03;

public class Test05 {

	// output O  input x
	static int func3() {
		return 123; // 자기자신을 호출한 위치로 값을 반환+함수를 종료
	}

	static int f1() {
		int num=123;
		return num;
	}
	static int f2() {
		int num=10;
		return num;	// 함수를 즉시 종료
	}

	public static void main(String[] args) {

		int num=1;
		num=f1();
		System.out.println("num= "+num);
		System.out.println(f2());





		/*
	      int num=func3();
	      // 1. func3()의 값을 알아야한다!
	      // 2. 대입 연산자를 수행
	      System.out.println("num= "+num);

	      System.out.println(func3());
		 */


	}
}
