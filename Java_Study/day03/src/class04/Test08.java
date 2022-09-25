package class04;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴판");
			System.out.print("1. 아메리카노 2. 카페라떼 3. 프라푸치노");
			System.out.println();
			System.out.print("메뉴를 선택해주세요 >>> ");
			int pick = sc.nextInt();
			
			
			String menu = "";
			if(pick == 1) {
				menu = "아메리카노";
			} else if(pick == 2) {
				menu = "카페라떼";
			} else if(pick == 3) {
				menu = "프라푸치노";
			} else {
				System.out.println("잘못입력하였습니다 다시 입력햊세요");
				continue;
			}
			System.out.println(menu + "나왔습니다!");
			break;
		}
	}
}
