package class01;

public class Test03 {
	public static void main(String[] args) {
		
		
		// [최댓값 찾기] 알고리즘
		int[] data = {1,5,3,10,8};
		int MAX=data[0]; // [0]의 값을 MAX라고 단정한다.
		
		// 검증
		for (int i = 0; i < data.length; i++) {
			if(MAX < data[i]) {
				// MAX가 올바르지 않으면 변경됩니다.
				MAX = data[i];
				System.out.println("MAX변경: " + MAX);
			}
		}
		System.out.println("MAX= " + MAX);
		
		
		
	}
}
