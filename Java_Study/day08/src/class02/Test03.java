package class02;

class Point{
	int x;
	int y;
	void showInfo() {
		System.out.println("P(" + this.x+ "," + this.y + ")");
	}
	Point(){
		this(0, 0);
		System.out.println("기본 생성자");
	}
	Point(int x){
		this(x, x);
		System.out.println("인자가 1개인 생성자");
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("인자가 2개인 생성자");
	}
}



public class Test03 {

	public static void main(String[] args) {
		
		Point p1 = new Point(10, 20);
		Point p2 = new Point();
		Point p3 = new Point(123);
		
		p1.showInfo();
		p2.showInfo();
		p3.showInfo();
	}
}
