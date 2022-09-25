package class01;

import java.util.ArrayList;
import java.util.Iterator;

public class Test01 {

	public static void main(String[] args) {
		// for, forEach / while 문
		int[] data = new int[5];
		data[0] = 10;
		data[1] = 20;
		data[2] = 30;
		System.out.println(data);
		
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		data2.add(10);
		data2.add(20);
		data2.add(30);
		System.out.println(data2); // 이미 toString이 오버라이딩 되어 있다.
		
		for(int i = 0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		for(int i = 0; i<data2.size(); i++) {
			System.out.println(data2.get(i));
		}
		for(int v : data2) { //forEach문 
			System.out.println(v);
		}
		Iterator<Integer> itr = data2.iterator(); // forEach문과ResultSet이랑 성향이 거의 유사함
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		/////////////////////////////////    MVC    /////////////////////////////////////////////
		// 로직별로 코드를 작성하지 말자
		// M : 데이터의 형태(자료형,갯수,....)
		// 	   DB와의 연결 -> JDBC
		//	   CRUD
		// V : 사용자 편의성 고려(UI/UX)
		//	   유효성 검사(자료형, 기본적인 범위)
		// C : M <--> V
		//	   로그(로깅기법)를 자주 확인하자
		//	   M에게 가는 데이터가 유효한지(유효성 검사), V에게 가는 데이터가 올바른지
		//////////////////////////////////////////////////////////////////////////////////////////
		
		// 코딩 할 때 유의사항
		// ※ 1로직 1로그 습관
		//		ㄴ 스스로 예상한 로그와 같은지 확인
		//		   -> 로그가 맞지 않다면 디버깅표
		// ※ 예외
		//			1) 발생한 라인넘버
		//			2) 이유
		//			3) 해결방법 구글링
		//			4) 포스팅
		// ※ 주석 생활화
		// ※ 메소드 사용할 때에 메소드 시그니쳐 확인 필수
		// ※ 자료형, 갯수, 메소드 형태(오버로딩, 오버라이딩)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
