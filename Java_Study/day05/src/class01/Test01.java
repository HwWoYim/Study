package class01;

public class Test01 {

	public static void main(String[] args) {
		
		// 회사 코딩테스트
		// 배열 -> 자료구조 + 알고리즘
		// 정렬
		
		// 배열을 사용한다는 건, 여러개의 데이터를 다루는 상황이며
		// 탐색(검색) 하겠다는 말이고 탐색을 효율적으로 하려면? -> 정렬을 잘해야한다.
		
		// 배열 정렬 알고리즘
		// : 버블, 삽입, 선택, 퀵, 셀, 도수......
		
		// [버블(거품) 정렬]
		
		int[] data = {2,8,5,9,7,3,1};
		// int[] data = new int[5];
		// -> {0,0,0,0,0};
		
		// 유지보수 유리
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		
		for (int j = 0; j < data.length; j++) {
		for(int i = 0; i < data.length - 1; i++) {
		if(data[i] > data[i+1]) {
			int tmp = data[i];
			data[i] = data[i+1];
			data[i+1] = tmp;
		}
		}	// 1회전 정렬
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		}
		
		
		
		
		
	}

}
