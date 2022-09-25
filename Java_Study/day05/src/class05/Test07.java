package class05;

import java.util.Random;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		// 코딩테스트: 삽입,선택 정렬

		// 랜덤 관련 알고리즘
		Random random=new Random();
		///System.out.println(random.nextInt(6)+1); // 0~5 +1 => 1~6

		Scanner sc=new Scanner(System.in);
		int L=1;
		int H=100;
		int ans=random.nextInt(100)+1; // 1~100
		int LIFE = 5;	// flag 의 개념

		while(true) {
			for(int i = 0; i<LIFE; i++) {
				System.out.print("♥");
			}
			System.out.println();
			System.out.print(L+"~"+H+" 정답: ");
			int num=sc.nextInt();
			System.out.println();

			if(num==ans) {
				System.out.println("정답입니다! "+ans);
				break;
			}
			if(LIFE==0) {
				System.out.println("게임오버......");
				break;
			} else if(num>ans) {
				System.out.println("DOWN!");
				H=num-1;
				
			} else {
				System.out.println("UP!");
				L=num+1;
			}
			LIFE--;
		}


	}
}
