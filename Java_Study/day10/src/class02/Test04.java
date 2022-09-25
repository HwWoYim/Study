package class02;

class Point {
	private int x;
	private int y;

	// 멤버변수에 직접접근을 하는것을 막아주는 메서드 : getter,setter
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

public class Test04 {

	public static void main(String[] args) {

		Point[] data = new Point[3];
		data[0] = new Point(1, 2);
		data[1] = new Point(10, 11);
		data[2] = new Point(3, 45);

		data[0].setX(10);
		data[0].setY(10);
		System.out.println("(" + data[0].getX() + "," + data[0].getY() + ")");

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i].getX() + "|" + data[i].getY());
		}

	}

}