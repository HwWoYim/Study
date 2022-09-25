package class02;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		if(num2 > num3) {
			int tmp = num2;
			num2 = num3;
			num3 = tmp;
		}
		while(num2<=num3) {
			System.out.print(num2 + " ");
			num2++;
		}
	}
}
