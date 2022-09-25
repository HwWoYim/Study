package class03;

import java.util.HashSet;
import java.util.Set;

public class Test05 {

	public static void main(String[] args) {
		
		// Set 집합
		// : 중복된 데이터를 허용하지 않는다
		// : 순서가 없다
		// 추상 클래스라 new연산자를 사용할 수 없음 -> 객체를 생성 할 수 없음
		Set s = new HashSet();
		s.add(10);
		s.add(10);
		s.add(10);
		s.add(20);
		s.add(20);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		System.out.println(s);
		System.out.println(s.size());
		
		
		
	}
}
