package class04;

import java.util.Scanner;

public class Ddfsdf {
	public static void main(String[] args) {

		//[이진탐색(이분검색)]
		//-> 탐색할 대상이 "정렬" 되어 있어야 사용할 수 있다!

		int[] data = {1,40,50,55,60,70,80,92,94,100}; //배열

		Scanner sc = new Scanner(System.in);

		while(true) { //몇번 반복할지 모르므로 while
			boolean flag = true; //어떤 행위가 잘 되었는지 체크하기 위한 변수

			System.out.println("검색: ");
			int num = sc.nextInt();

			int L = 0; //index는 0부터 시작하므로 0,1,2...
			int H = data.length-1;


			while(true) {
				int M = (L+H)/2;  //가운데 index를 변수 M에 저장

				//종료조건 설정
				if(data[M]==num) {
					System.out.println(M+"번째에 "+num+"이 존재합니다!");
					break;

				}else if(data[M]>num) { //Down 인 상황 (정답이 중간index보다 아래에 있음)
					H = M-1; //M번째 index보다 전index가 H값이 되므로
					System.out.println(L+"~"+H+"중 검색:");

				}else {
					L = M+1; //M번째 index의 다음 index부터 L값이 되므로
					System.out.println(L+"~"+H+"중 검색:");

				}
				if(L>H) { //cross 가 된다면 
					System.out.println("찾는 데이터가 없습니다!");
					flag = false;//종료조건에 데이터가 없으면 flase 이므로
					break;
				}

			}




			//종료조건 먼저 설정, 내가 찾는 데이터가 있는 상황==true, 아님 false
			if(flag) {//if (true){실행할문장;}
				break;
			}
			}
		
	}
}
