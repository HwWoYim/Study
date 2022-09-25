package class05;

import java.util.Random;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int ans = rd.nextInt(100)+1;
		int L = 0;
		int H = 100;
		
		while(true) {
			int heart = 3;
			while(heart > 3) {
				System.out.print("♥");
			}
			System.out.println();
			System.out.println("정답 입력>>> ");
			int num = sc.nextInt();
			
			if(num==ans) {
				System.out.println("정답입니다!!!!");
				break;
			}else if(num<ans) {
				System.out.println("UP!!");
				L=num+1;
				heart =- 1;
			}else {
				System.out.println("DOWN!!");
				H=num-1;
				heart =- 1;
			}

		
		
		
		}
		
	}
}
