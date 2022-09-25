package class07;

public class Test10 {
	public static void main(String[] args) {
		
		// 복합대입 연산자
		int a = 1000;
		int b = 2000;
		int c = 1500;
		int total = 0;
		
		total += a;	// 연산자 2개, total 변수공간을 2번 방문
		total += b;
		total += c;
		
		System.out.println(total);
		
		
	}
}
