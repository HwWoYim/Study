package class03;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("입력 : ");
			int line = sc.nextInt();
			
			if(line < 1) {
				System.out.println("다시!");
				continue;
			} else {
				for (int a = 1; a <= line; a++) {
					for (int i = 1; i <= (line-a); i++) {
						System.out.print(" ");
					}
					for (int j = 1; j <= a; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
			}
			break;
		}
		
		
		
		
		
	}
}
