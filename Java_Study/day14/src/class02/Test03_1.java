package class02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(-1);
		al.add(0);
		al.add(1);
		al.add(2);
		al.add(3);
		System.out.println("로그: 배열리스트 확인: "+al);

		Scanner sc=new Scanner(System.in);
		int res=10;
		while(true) {
			try {
				System.out.print("정수입력) ");
				int num=sc.nextInt();         
				res=10/al.get(num);
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("로그: 인덱스범위예외발생: "+e.getMessage());
				continue;
			}
			catch(ArithmeticException e) {
				System.out.println("로그: 예외발생: "+e.getMessage());
				continue;
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("로그: 미확인예외발생!");

			}
			System.out.println("결과= "+res);

			break;
		}
	}
}