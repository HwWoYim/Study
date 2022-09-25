package class03;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {
		Random rd = new Random();

		Set<Integer> s = new HashSet<Integer>();
		
		while(s.size()<7) {
			s.add(rd.nextInt(10)+1);
		}
		System.out.println(s);
		
	}
}
