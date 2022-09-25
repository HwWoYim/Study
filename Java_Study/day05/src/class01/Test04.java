package class01;

public class Test04 {
	public static void main(String[] args) {
		
		// 최솟값을 찾아주세요
				// 최솟값은 1이고, [0]에 존재합니다.
				int[] data1 = {5,8,6,4,9};
				int MIN = data1[0];
				int INDEX = 0;	// 최소값의 위치(index)를 저장할 변수
				// INDEX를 초기화해야만 하는 이유
				// 1) 최소값이 [0]에 존재할 때
				// 2) 수도코딩에 의해
				
				for (int i = 0; i < data1.length; i++) {
					if(MIN > data1[i]) {
						MIN = data1[i];
						INDEX=i; // 최소값을 찾았으니 그 위치를 저장하자.
					}
				}
	
				System.out.println("MIN: " + MIN);
				System.out.println("INDEX= " + INDEX);
		
	}
}
