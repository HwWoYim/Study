package class03;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
//		int i = 0;
//		int sum = 0;	// 약수들을 저장하는 역할
//		while(i < num) {
//			i++;
//			if(num % i == 0 && i < num) {
//				sum += i;
//				System.out.print(i + " ");
//			}
//		}
//		if(num == sum) {
//			System.out.println();
//			System.out.println(num + "은 완전수 입니다."); 
//		}
		
		int i = 0;
		int total = 0;
		while(i < num-1) {
			i++;
			if(num%i == 0) {
				total += i;
			}
		}
		System.out.println("total: " + total);
		if(total==num) {
			System.out.println("완전수");
		} else {
			System.out.println("완전수 아님");
		}
		
		
		
	}
}
