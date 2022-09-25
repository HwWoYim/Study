package class01;

public class Test03 {
	static void func1() {
		int num=10;
		num++;
		System.out.println("func1(): "+num);
	}	// 메모리 공간 해제

	static void func2(int a) {
		a++;
		func1();
		System.out.println("func2(): "+a);
	}

	public static void main(String[] args) {

		int num=1;
		int a=100;

		func1();
		func2(num);	// "값"

	}



}

