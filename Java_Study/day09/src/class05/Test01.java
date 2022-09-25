package class05;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	static void f1(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	static int[] f2(int num) {
		Random rand = new Random();

		int[] data = new int[num];
		int i = 0;
		while(i<data.length) {
			int randNum=rand.nextInt(50)+1;
			boolean flag = false;	// T:중복발생 F:중복없음(통과)
			// 램던수를 우선 생성해보고,
			// 기존의 배열에 랜덤수가 존재한다면, 다시 위로
			// 존재안하면, 아래로
			for (int j = 0; j < i; j++) {
				if(randNum==data[j]) {
					flag = true;
					break;
				}
			}
			if(flag) {
				continue;
			}
			data[i] = randNum;
			i++;
		}

		return data;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;	// 유효범위
		while(true) {

			System.out.println("정수입력: ");
			num = sc.nextInt();
			if(1<=num && num<=50) {
				break;
			}
			System.out.println("1이상 50이하만 입력하세요!");
		}

		int[] lotto = f2(num); // [ 0 0 0 0 0 ]
		f1(lotto);

	}
}
