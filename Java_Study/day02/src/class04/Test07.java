package class04;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 제어문
		// 1. 조건문 -> 할 때도 있고, 안할 때도 있을 때 사용
		// : if, switch
		// 2. 반복문 ->  
		// : while, for
		
		System.out.print("정수1 입력 : ");
		int a = sc.nextInt();
		System.out.print("정수2 입력 : ");
		int b = sc.nextInt();
		
		if(a > b) {
			System.out.println(a + "가 큽니다.");
		} else if(a < b) {
			System.out.println(b + "가 큽니다.");
		} else if(a == b) {
			System.out.println("두 수가 같습니다.");
		}
		
		
		System.out.println("정수 입력 : ");
		int c = sc.nextInt();
		
		if(c >= 0) {
			System.out.println("양수 입니다.");
		} else {
			System.out.println("음수 입니다.");
		}
		
		
		System.out.println("정수 입력 : ");
		int d = sc.nextInt();
		
		if(d % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
		
	}
}
