package class02;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// ctrl + shift + o => 자동 import 단축키

		// int a = 10;  => 원시타입
		// double b = 3.14;  => 원시타입
		String str = new String("apple");
		String c = "apple"; // 객체라는 건 클래스를 통해 생성되는거다.
		// String이라는 클래스가 있다
		// 이를 통해 str이라는 이름의 객체를 생성하겠습니다.
		// new 클래스(재료) << 행위를 통해서 객체를 생성할 수 있다.

		// 유효성 검사
		System.out.print("정수입력: ");	// 사용자의 편의성을 고려하자!!!!!!!
		sc.nextInt();
		System.out.print("실수입력: ");
		sc.nextDouble();
		

	}
}
