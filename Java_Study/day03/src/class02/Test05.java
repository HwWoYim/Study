package class02;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 소수 : 약수가 1과 자기자신밖에 없는 정수
		// ex) 2,3,5,7,11,13,17,...... -> 약수의 개수가 2개인 정수
		// 1은 소수가 아닙니다.
		
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		int i = 0;
		int cnt = 0;	// 약수의 갯수를 기억할 변수가 필요!
		while(i<num) {
			i++;
			if(num%i==0) {
				cnt++;
			}
		}
		
		if(cnt == 2) {
			System.out.println("소수 입니다.");
		} else {
			System.out.println("소수 아닙니다.");
		}
		
		
		
		
		
		
	}
}
