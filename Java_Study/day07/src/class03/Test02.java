package class03;

public class Test02 {

	static int func(int a,int b,int c){
		if(a>b) {
			if(a>c) {
				return a;
			}
			else {
				return c;
			}
		}
		else {
			if(b>c) {
				return b;
			}
			else {
				return c;
			}
		}
	}

	public static void main(String[] args) {
		int num1=10;
		int num2=20;
		int num3=15;

		int NUM=func(num1,num2,num3);
		System.out.println(NUM+"이 가장 큰 정수입니다!");

	}
}

