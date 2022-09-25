package class01;

// OOP
class Point{
	int x;
	int y;
	static int z; // 클래스 변수 == 공유자원
	void showInfo() {
		System.out.println(this.x + " " + this.y);
	}
	Point(){
		this(0, 0);
	}
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Test01 {

	public static void main(String[] args) {
		
		Point p1 = new Point();
					//	↑↑↑↑인자가 없는 생성자
		Point p2 = new Point(10, 20);
		
		Point[] data = new Point[3]; // 객체 배열
		// 27번 라인 data는 그냥 배열이다
		data[0] = new Point(1,2);
		data[1] = p1;
		data[2] = p2;
		
		for (int i = 0; i < data.length; i++) {
			data[i].showInfo();
		// 34번 라인 data는 객체이다.
		}
		
		
		
		
	}
}
