package class03;

import java.util.Random;

public class Test09 {
	// 배열을 넣으면, 짝수를 모두 -- 시키는 로직
	static void func(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				arr[i]--;
			}
		}
	}


	public static void main(String[] args) {

		int[] data=new int[5];

		Random rand=new Random();
		for(int i=0;i<data.length;i++) {
			data[i]=rand.nextInt(10)+1;
		}
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();

		func(data);

		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();


	}

}
