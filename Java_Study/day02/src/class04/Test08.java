package class04;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		System.out.print("정수1 : ");
		int a = sc.nextInt();
		System.out.print("정수2 : ");
		int b = sc.nextInt();
		
		if(a > b) {
		int tmp = a;
		a = b;
		b = tmp;
		
		String msg = b%a == 0? "약수입니다." : "약수가 아닙니다.";
		System.out.println(a + "은 " + b + "의 " + msg);
	}

		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if((age >= 1 || age <= 12) && age >= 60 || age <=200) {
			System.out.println("무료입니다.");
		} else if(age >= 13 || age < 20) {
			System.out.println("1000원 입니다.");
		} else if(age >= 20 || age < 60) {
			System.out.println("2000원 입니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
