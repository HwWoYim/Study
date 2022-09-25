package class02;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 // 1~100까지
	      int ans=79; // 정답 정수
	      int L=1;
	      int H=100;
	      
	      while(true) {
	         
	         System.out.print(L+"~"+H+" 정답입력: ");
	         int num=sc.nextInt();
	         // 유효성 검사
	         //  : 입력 즉시 진행되는 편임
	         if(num<L || H<num) {
	            System.out.println("다시입력!!!");
	            continue;
	         }
	         
	         if(num==ans) {
	            System.out.println("정답입니다!");
	            break;
	         }
	         else if(num>ans) {
	            System.out.println("DOWN!");
	            H=num-1;
	         }
	         else {
	            System.out.println("UP!");
	            L=num+1;
	         }
	         
	      }

		
		
		
		
		
		
		
	}
}
