package class02;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);

	// 3. 정수입력 : 10
			// 1 2 5 10 -> 약수들만 출력
	System.out.println("정수 입력 >>>");
	int num4 = sc.nextInt();
	int i = 1;
	while(i <= num4) {
		if(num4 % i == 0) {
			System.out.print(i + " ");
		}
		i++;
	}
	
	
	
	
	
	}
}
