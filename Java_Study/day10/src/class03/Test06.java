package class03;

class A {
	int a;
	int b;

	/*
	 * A(){ System.out.println("A 기본생성자"); }
	 */
	A(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("A 생성자");
		System.out.println(a + ":a " + b + ":b ");
	}
}

// 하위 클래스인 B를 코딩하고있는 상황은,
// A의 설계가 완료되었음을 의미
class B extends A {

	int c;

	B() {
		super(10, 20);
		// A의 기본생성자를 사용하지않는 상황!
		// => A에게 존재하는 다른 생성자를 사용해서, 나의 A부분을 완성!

		// 부모에게 기본생성자가 없다면, 모든 자식생성자에서 문제발생!★★★★★
		this.c = 0;
		System.out.println("B 기본생성자");
	}
}

public class Test06 {
	public static void main(String[] args) {

		A aaa = new A(123, 123);
		System.out.println("---------------------");
		B bbb = new B();

	}
}