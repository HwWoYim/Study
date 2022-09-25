package class01;

public class Test02 {

	// input x output x
	static void func1() {
		System.out.println("소리가 들린다!");
		System.out.println("주의! 경고!");
	}	// 코드 재사용성을 증가시키기 위해 쓴다.

	// input o output x
	static void func2(int a) {
		System.out.println("func2()에서 받은 num: " + a);
	}


	public static void main(String[] args) {

		int a = 100;
		func2(a);
		a++;
		func2(a);
		System.out.println("main(): " + a);


	}
}

