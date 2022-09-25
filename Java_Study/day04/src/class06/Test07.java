package class06;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {

		// 나 배열 쓰고 싶으니까 그만큼의 공간을 생성해줘!
		// 객체는 초기화를 디폴트로 해준다.
		int cnt = 5; //여기에 학생수 넣으시면 됩니다.
		int[] arr = new int[5];

		

		Scanner sc = new Scanner(System.in);
		sc.next();

		// 주어가 될 수 있는 것들은 객체이다
		// 주어가 될 수 있다는 것은 동사를 가질 수 있다는 뜻이며
		// 함수를 주체적으로 수행할 수 있다는 뜻입니다.
		// 모든 객체는 new를 사용해서 만들어진다.

		//		int i=10;
		//	      String str="apple";
		//	      String str=new String("apple");
		//	      
		//	      
		//	      str.equals("apple") <<
		//	      str=="빨강" -> 연산자의 대상은 변수인데,,
		//	               str은 변수가아닙니다! 객체였어요!!
		//	               
		//	      . >> 주어==함수 수행 가능
		int i = 0;
		while(true) {
			System.out.println("학생" + (i + 1) + "성적입력 : ");
			arr[i] = sc.nextInt();
			if(arr[i]<0 || 100<arr[i]) {
				System.out.println("1~100까지만 입력가능");
				continue;
			}
		}
		
		
		
		

	}
}
