package class02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = -1; i < 4; i++) {
			al.add(i);
		}
		System.out.println("로그 : 배열리스트 확인 : " + al);
		
		int num = sc.nextInt();
		int a = (int) al.get(num);
		try {
			int num2 = 10 / a;
			System.out.println(num2);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); 
		} catch(Exception e) {
			
		}
	}
}
