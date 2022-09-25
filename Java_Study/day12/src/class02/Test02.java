package class02;
// [추상클래스]
// 객체화를 하지못하게 "강제"
abstract class Shape{	// 객체생성을 위해서 사용 xxx -> 클래스들을 정의 O
	int a;	// 점, 선
	abstract void draw();
	void showInfo() {
		System.out.println("모양: " + this.a);
	}
	Shape(int a){	// 생성자를 정의할 수 있음! -> 자식 생성자에서 호출한다
		this.a = a;
	}
}
class Circle extends Shape{
	int radius;
	Circle(int a, int radius){
		super(a);
		this.radius = radius;
	}
	@Override
	void draw() {
		System.out.println("그림그리기");
	}
}
public class Test02 {
	public static void main(String[] args) {
		// Shape s = new Shape();
		// 추상클래스 : 객체화, 인스턴스화 못시킴
		
		Circle c = new Circle(1, 2);
		// 추상클래스는 부모클래스의 역할을 할 수 있다
		c.draw();
		c.showInfo();
	}
}
