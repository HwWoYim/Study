package class01;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("시간: ");
		int h = sc.nextInt();
		System.out.print("분 : ");
		int m = sc.nextInt();

		if((h < 1 || 12 < h) || (m < 0 || 59 < m)) {
			System.out.println("프로그램 종료");
		} else {
			System.out.println(h + "시 " + m + "분의 1시간 20분 전 시간은");
			h--;
			m-=20;
			if(m < 0) {
				m += 60;
				h--;
			}
			if(h<1) {
				h += 12;
			}
			System.out.println(h + "시 " + m + "분 입니다.");
		}

		// 검사 == 테스트
		// 1) 경계값 검사
	}

}
