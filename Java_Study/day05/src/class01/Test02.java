package class01;

public class Test02 {
	public static void main(String[] args) {

		int[] data = {5,3,2,4,1};
		
		// 버블정렬
		for (int a = 0; a < data.length; a++) {
			for (int i = 0; i < data.length-1; i++) {
				if(data[i]>data[i+1]) {
					int tmp = data[i];
					data[i]=data[i+1];
					data[i+1]=tmp;
				}
			}
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

	}
}
