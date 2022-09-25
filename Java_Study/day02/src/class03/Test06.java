package class03;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력: ");
		int a = sc.nextInt();
		System.out.print("정수2 입력: ");
		int b = sc.nextInt();
		
		if(a % b == 0) {
			System.out.println(b + "은(는) " + a + "의 약수입니다.");
		} else {
			System.out.println(b + "은(는) " + a + "의 약수가 아닙니다.");
		}
		
		
		
	}
}
