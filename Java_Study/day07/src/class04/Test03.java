package class04;

// 클래스를 정의, 또는 선언 하였다. : 붕어빵 틀 부분이 됩니다!
class Circle{	// 클래스명은 항상 대문자 시작~
	int radius;	// 멤버변수
	String name;	// 멤버변수는 객체마다 고유하게 가질 수 있다.
	Circle(int radius, String name){
		this.radius = radius;
		this.name = name;
	}
	
	void print() {	// 멤버함수 == 메소드
		System.out.println(name + ": " + radius);
	}
}

public class Test03 {
	
	static void f() {
		System.out.println("주어 없이 바로 호출해야 이용하는 함수");
	}
	public static void main(String[] args) {
		// [객체 지향 프로그래밍] : OOP : Object Of Program
		
		Circle c1 = new Circle(10, "도넛");
		Circle c2 = new Circle(50, "피자");
		// c : 원 객체 생성완료! 붕어빵 하나 만든거입니다.
		// new : 객체화 == 인스턴스화
		
		// 원 모양의 객체들을 앞으로 만들어보자.
		// 객체를 만들고 싶음 -> OOP
		// 객체를 만들기위해서는 "클래스" 를 먼저 정의해야 합니다!
	
		
		
		c1.print();
		c2.print();
		
		
	}
}
