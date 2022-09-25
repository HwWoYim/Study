package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1111 {
	public static void main(String[] args) {
		
		//[forEach문]
		int[] data = {10,20,30};
		
		for (int v : data) {	//v : 복사체
			v++;
			System.out.println(v);
		}
		for (int v : data) {
			System.out.println(v);
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		
		for(int v : al) {
			System.out.println(v);
		}
		System.out.println("-------Iterator--------s");
		Iterator itr = al.iterator(); // 복사체
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
