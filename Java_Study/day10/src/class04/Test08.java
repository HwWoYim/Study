package class04;

class Point {
	int x;
	int y;

	void move(int x) {
		this.x = x;
		this.y = x;
	}

	void showInfo() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}

	Point() {
		this(0, 0);
	}

	Point(int x) {
		this(x, x);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point {
	String color;

	void cc(String color) {
		this.color = color;
	}
	void showInfo() {
		System.out.println(this.color + "(" + this.x + "," + this.y + ")");
	}

	void showInfoColorPoint() {
		System.out.println(this.color + "(" + this.x + "," + this.y + ")");
	}

	ColorPoint() {
		this("black", 0, 0);
	}

	ColorPoint(String color) {
		this(color, 0, 0);
	}

	ColorPoint(String color, int x, int y) {
		super(x, y);
		this.color = color;
	}
}

public class Test08 {

	public static void main(String[] args) {
		
		ColorPoint cp = new ColorPoint("pink");
		cp.showInfo();

	}

}