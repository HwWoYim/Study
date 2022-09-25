package class05;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		
		System.out.print("정수 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 >> ");
		int num2 = sc.nextInt();
		
		for (int i = 0; i < num1; i++) {
			 if(num1 > num2)
	                num1 -= num2;
	            else
	                num2 -= num1;
			}
		
		System.out.println("G.C.D = " + num1);
		
		
		
	}
}
