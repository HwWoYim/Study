package class04;

class Shape {
	String name;
	double area;

	void showInfo() {
		System.out.println(this.name + " " + this.area);
	}

	Shape(String name) {
		this.name = name;
		this.area = 0.0;
		System.out.println("Shape의 생성자-1");
	}
}

class Circle extends Shape {
	int radius;
	static final double PI = 3.14; // 상수 <->변수

	void showInfoCircle() {
		System.out.println(this.name + " " + this.area + " " + this.radius);
	}

	Circle(int radius) {
		super("원"); // 부모에게 기본생성자를 추가할수도있지만,
		// 설계를 바꾸는것이기때문에 실무xxx
		// -> 부모의 생성자를 사용하여 해결!
		this.radius = radius;
		this.area = this.radius * this.radius * PI;
		System.out.println("Circle의 생성자-1");
	}
}

public class Test07 {

	public static void main(String[] args) {
		Circle c1 = new Circle(10);
		c1.showInfo();
		c1.showInfoCircle();
	}

}