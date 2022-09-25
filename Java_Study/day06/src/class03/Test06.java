package class03;

public class Test06 {
	
	// output o input o
	static int func4(int a, int b) {
		return a+b;
	}
	
	static int func4(int a, int b, int c) {
		return a+b+c;
	}
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(func4(a,b));
		System.out.println("a= " + a);
		System.out.println("b= " + b);
	}
}
