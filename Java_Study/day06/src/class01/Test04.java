package class01;

public class Test04 {

	// 함수명 중복정의 허용
	// 인자의 개수가 다르거나,
	// 인자의 자료형이 달라야만 한다.
	// ★★★ 오버로딩 ★★★
	static void add(int a, int b) {
		System.out.println(a + b);
	}
	static void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	static void add(int a, int b, int c, int d) {
		System.out.println(a + b + c + d);
	}
	static void add(int a, int b, int c, int d, int e) {
		System.out.println(a + b + c + d + e);
	}

	static void f(int a) {
		System.out.println("a");
	}
	static void f(double a) {
		System.out.println("b");
	}
	static void f(String a) {
		System.out.println("c");
	}


	public static void main(String[] args) {

		f(3.14);
		f("a");


		// println() 함수는 오버로딩(함수명 중복정의 허용)으로 선언되어있었고, 우린 호출해서 사용했던 것이다.
		//		System.out.println();
		//		System.out.println(10);
		//		System.out.println("apple");
		//		System.out.println(3.14);
	}
}
