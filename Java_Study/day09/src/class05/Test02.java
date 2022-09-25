package class05;

public class Test02 {

	static void quick_sort(int[] data, int start, int end) {
		if(start>=end) {
			return; // 반환값을 나를 호출한 위치로 전달
			// 함수 즉시 종료
		}
		int pivot = data[start];
		int L = start + 1;
		int H = end;

		while (true) {
			while (pivot > data[L]) {
				if (L == end) { // L가 끝까지 도달했다면,
					break; // 그만해라
				}
				L++; // index 범위를 ++, -- 때에는 Exception에 유의하자!
			}
			while (pivot < data[H]) {
				if (H == start) {
					break;
				}
				H--;
			}
			System.out.println("L=" + L + ", H=" + H);

			if (L >= H) {
				int tmp = data[start];	// 배열의 요소값을 교환한다
				data[start] = data[H];
				data[H] = tmp;
				break;
			}
			int tmp = data[L];
			data[L] = data[H];
			data[H] = tmp;
		}
		quick_sort(data,start,H-1);
		quick_sort(data,H+1,end);
	}

	public static void main(String[] args) {

		// 재귀함수????
		// 로직을 코드로 옮길 수 있나?

		int[] data = { 5, 1, 9, 10, 4, 2, 7, 3, 6, 8 };

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
			System.out.println();

			quick_sort(data, 0, data.length - 1);
			// 메소드 시그니처 : 함수3요소 -> input, output, 기능
			// int[]x1, intx2 | xxx(void) | 퀵 정렬

			for (int j = 0; j < data.length; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println();
		}
	}
}
