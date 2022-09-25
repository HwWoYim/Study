package class02;

// 멤버변수 : 인스턴스(객체) 변수 /          ||   클래스 변수==[공유자원]
class A{
	int num1;	// 멤버변수 -> 객체마다 고유한 값을 가지고 있다. == 객체끼리 값을 공유하지 않는다
	// 인스턴스(객체) 변수
	int num2;	// 객체끼리 값을 "공유"한다는건....a객체의 변화가 b객체에도 영향을 줌!
	void showInfo() {
		System.out.println("num1= " + num1);
		System.out.println("num2= " + num2);
	}
	A(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
}

public class Test05 {

	public static void main(String[] args) {

		A a1 = new A(1, 2);
		A a2 = new A(10, 20);

		a1.num1 += 100;
		a1.num2=2;

		a1.showInfo();
		a2.showInfo();

	}
}
