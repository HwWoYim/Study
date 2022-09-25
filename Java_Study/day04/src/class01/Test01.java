package class01;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수: ");
		int a = sc.nextInt();
		System.out.println("정수: ");
		int b = sc.nextInt();
		
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int i;
		for(i=a; i>=1; i--) {
			if(a % i == 0 && b % i == 0) {
				break;
			}
		}
		
		System.out.println(a + "와(과) " + b + "의 ");
		System.out.println("최대공약수는 " + i + "이고,");
		System.out.println("최소공배수는" + (a*b/i) + "입니다.");
		
		
		
		
		
		
		
		
		
		
		
	}
}
