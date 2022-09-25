package class02;

public class Test03 {
	public static void main(String[] args) {
		// 조건 연산자(삼항 연산자)
		// int num = 조건식? T:F;
		int res = 10>5 ? 1 : 2;
		System.out.println(res);
		
		int a = 10, b = 9;
		int max = a>b ? a : b;
		System.out.println(a + "와 " + b + "중에서 더 큰 값은 " + max + "입니다.");
		
		// a, b, c 라는 정수 3개가 존재합니다.
		// a, b, c 값은 각자 다 다릅니다.
		// a, b, c 중에서 가장 작은 값은 ____입니다.
		
		int num1 = 15, num2 = 20, num3 = 25;
		int num4 = num1 < num2 ? num1 : num2;
		num4 = num4 < num3 ? num4 : num3;
		System.out.println("제일 작은 값은 " + num4 + "입니다.");

	}
}
