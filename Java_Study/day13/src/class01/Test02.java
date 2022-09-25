package class01;

import java.util.ArrayList;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Random rd = new Random();
		ArrayList al = new ArrayList();
		int odd = 0;
		int num = 0;
		int sum = 0;
		
		while(odd < 5) {
			 num = rd.nextInt(9)+1;
			 if(!(num % 2 == 0)) {
				 al.add(num);
				 odd++;
				 sum += num;
			 }
		}
		System.out.println("홀수로 구성 된 랜덤 배열: " + al);
		System.out.println("배열의 총합: " + sum);
		System.out.println("총합의 나눈 값: " + (double)sum/2);
	}
}
