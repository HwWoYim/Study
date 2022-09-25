package class03;

public class Test08 {
	
	static void func1(int i) {
		i += 10;
	}
	
	static void func2(int[] arr) {
		arr[0] =-100;
		arr[arr.length-1] =- 123;
	}
	public static void main(String[] args) {
		
		int num = 10;
		int[] data = {1,2,3,4,5};
		
		func1(num);
		System.out.println("num= " + num);
		
		func2(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
