package class01;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1~100까지
		int ans = 97; // 정답 정수
		
		while(true) {
			
			System.out.print("정답입력: ");
			int num = sc.nextInt();
			if(num==ans) {
				System.out.println("정답입니다!");
				break;
			} else if(num>ans) {
				System.out.println("DOWN!");
			} else {
				System.out.println("UP!");
			}
		}
		
	}
}
