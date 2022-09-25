package class03;

//[상속]
class Shape { // 모양 클래스 : 부모, 상위 클래스
	String name;
	double area;

	void showInf() {

	}

	void showInfo() {
		System.out.println(this.name + " " + this.area);
	}

	Shape() {
		System.out.println("Shape에서 호출한 기본생성자");
	}

}

class Circle extends Shape { // 원 클래스 : 자식, 하위 클래스
	int radius;

	Circle() {
		super();

		// 모든 자식 생성자에서는 가장 먼저 부모의 기본 생성자를 호출한다!!!★★★★★★★★
		System.out.println("Circle에서 호출한 기본생성자");
	}
}

public class Test05 {

	public static void main(String[] args) {

		Circle c = new Circle();
		// 부모의 멤버변수, 메소드를 자식이 사용가능

		System.out.println("----------------------------------");

		Shape s = new Shape();
		// 부모는 자식클래스를 참조할 수 없음
	}
}
