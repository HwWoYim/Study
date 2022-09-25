package class02;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력: ");
		int a = sc.nextInt();
		System.out.print("정수2 입력: ");
		int b = sc.nextInt();
		
		int max = a>b ? a : b;
		System.out.println(a + "와 " + b + "중에서 더 큰 값은" + max + "입니다.");
		
		
		
		
	}
}
