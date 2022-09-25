package class04;

import java.util.Scanner;

public class Test06 {
		public static void main(String[] args) {
			
			// [이진탐색(이분검색)]
			// -> 탐색할 대상 배열이 "정렬"되어있어야만 합니다! :D
			
			int[] data = {1,40,50,55,60,70,81,92,94,100};
			
			Scanner sc = new Scanner(System.in);
			
			
			boolean flag = true;	// T / F 밖에 없다., 어떠한 실행이 잘 되었는지 체크하는 변수
			int L=0;
			int H = data.length-1;
			
			while(true) {
				
				
				System.out.println("검색: ");
				int num = sc.nextInt();
				
				int M = (L+H)/2;	// M: L~H의 가운데이다. 
				if(data[M] == num) {
					System.out.println("[" + M + "]에 " + num + "가 존재합니다!");
					break;
				} else if(data[M] > num) {	// DOWN 상황
					H = M-1;
	
				} else {	// UP 상황
					L = M+1;
				}
				
				if(L>H) {	//교차(cross) 상황
					System.out.println("찾는 데이터가 없습니다!");
					flag=false;	// 만약 찾으려는 데이터가 없다면 F로 초기화해준다
					break;
				}
				
				if(flag) {	// flag변수가 T상태가 유지하면, 멈출 수 있다
					// 내가 원하는 데이터를 찾은 상황 -> T
					// 내가 찾으려는 데이터가 없는 상황 -> F
					break;
				}
			}
			
			
		}

}
