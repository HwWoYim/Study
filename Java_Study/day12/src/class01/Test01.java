package class01;

class Point{
	int x;
	int y;
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("위치변경완료!");
	}
	Point(){
		this(0,0);
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
class ColorPoint extends Point{
	String color;
	
	void move(String color, int x, int y) {
		this.color = color;
		super.move(x, y);
	}
	ColorPoint(){
		this("검정", 0, 0);
	}
	ColorPoint(String color){
		this(color, 0, 0);
	}
	ColorPoint(int x, int y){
		this("검정", x, y);
	}
	ColorPoint(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	@Override
	public String toString() {
		return this.color + "(" + this.x + ", " + this.y + ")";
	}
	
}
public class Test01 {

	public static void main(String[] args) {
		
		Point[] data = new Point[5];
		data[0] = new Point(10, 20);
		data[1] = new ColorPoint();
		data[2] = new ColorPoint(10, 20);
		data[3] = new ColorPoint("빨강");
		data[4] = new ColorPoint("파랑", -1, -2);
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i].toString()); //toString이 생략되어 있다. , ColorPoint는 인식하지 못하고 자기 자신영역을 먼저 확인해서 Point만 인식함
		}
		// 1. 실제로 저장된 객체는 ColorPoint임에도 불구하고, Point[]로 선어해두었기 때문에
		// .toString()이 Point것이라고 안내하고 있다.
		// 2. 그런데 Point 것이라고 안내해 놓고 ColorPoint것을 호출하여 사용하고 있다.
		// 3. 메소드를 호출해서 사용할 때 -> 자기자신 영역을 먼저 확인하고, 이후에 부모 영역을 확인하기 때문.
		// 4. => "동적 바인딩" == 다형성이 구현, 실현 되었다
		
	}
}
