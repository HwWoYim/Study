package class03;

// [함수 심화] : 재귀
// 재귀함수(순환함수) ex) 팩토리얼
public class Test07 {

	static int fac(int n) {
		if(n==1) {
			return 1;
		}
		return n*fac(n-1); // "종료조건"이 필요함!
	}

	public static void main(String[] args) {

		System.out.println(fac(5));

	}

}
