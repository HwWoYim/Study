package class01;

public class Test02 {
	public static void main(String[] args) {
		// [중첩 반복문] 또는 이중 for문
		
		//구구단
		for (int a = 2; a<=9; a++) {
			//8번
			for (int i = 1; i <= 9; i++) {
				//9번
				System.out.println(a + " x " + i + " = " + a*i);
			}
			System.out.println("-----------------------------------------------");
		}
	}
}
