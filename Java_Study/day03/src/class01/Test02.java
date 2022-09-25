package class01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {

		// 입력, 제어문-조건문 if -> 유효성 검사
		// "주석" -> 가독성 => ★유지보수★

		// while : 어떤(특정) 조건을 만족할 때까지 계속 ~~~할때까지 반복, 무한하게 or 영원히

		/*		for : N번, N회
			  a부터 ~ b까지
			  범위가 분명하게 주어졌을 때
			  "배열"(자료구조)
		 */	
		int i=1;
		while(i<=3) {
			System.out.println("확인");
			i++;
		}	// 조건식의 결과값이 true라면 "}"를 절대로 통과할 수 없음
			// => 다시 조건식으로 간다

		// 1. 정수 입력 : 5 (0이하 입력xxx)
		// 출력 예시 : 1 2 3 4 5
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 >>>");
		int num1 = sc.nextInt();
		i = 1;
		while(i <= num1) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println("\n-----------------------------------------");

		// 2. 정수 1입력 : 10
		// 정수 2 입력 : 5
		// 5 6 7 8 9 10
		// 정수 1입력 : 5
		// 정수 2입력 : 10
		// 5 6 7 8 9 10
		System.out.print("정수1 입력 >>>");
		int num2 = sc.nextInt();
		System.out.print("정수2 입력 >>>");
		int num3 = sc.nextInt();
		if(num2 < num3) {
			while(num2 <= num3) {
				System.out.print(num2 + " ");
				num2++;
			}
		} else {
			while(num3 <= num2) {
				System.out.print(num3 + " ");
				num3++;
			}
		}
		
		if(num2 > num3) {
			int tmp = num2;
			num2 = num3;
			num3 = tmp;
		}
		while(num2<=num3) {
			System.out.println(num2 + " ");
			num2++;
		}
		System.out.println("\n----------------------------------------------");
		
		// 3. 정수입력 : 10
		// 1 2 5 10 -> 약수들만 출력
		System.out.println("정수 입력 >>>");
		int num4 = sc.nextInt();
		i = 1;
		while(i <= num4) {
			if(num4 % i == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
		
		
		
		
		
	}
}
