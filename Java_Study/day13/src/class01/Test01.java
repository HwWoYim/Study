package class01;

import java.util.ArrayList;
class A{
	int a;
	int b;
	A(int a,int b){
		this.a=a;
		this.b=b;
	}
	@Override
	public String toString() {
		return "A 클래스로 만든 객체";
	}
}

public class Test01 {

	public static void main(String[] args) {
		// 컬렉션 프레임워크
		// [ArrayList]

		// 자료형xxx 제약 없음
		// 요소의 개수xxx
		ArrayList al = new ArrayList();
		System.out.println("1-----------");
		System.out.println(al); // 주소값이 안나오고 toString 이 오버라이딩 된 상태로 출력된다
		// abstract콜렉션이 ArrayList의 상위 클래스이다. Object가 아니다
		// toString()이 오버라이딩

		al.add(10);
		al.add(20);
		System.out.println("2-----------");
		System.out.println(al);
		al.add(0, 30);
		System.out.println("3-----------");
		System.out.println(al);

		 //al.clear();
	      //System.out.println(al);
		System.out.println("4-----------");
	      System.out.println(al.get(0));
	      System.out.println(al.get(1));
	      System.out.println("5-----------");
	      System.out.println(al.isEmpty());		// 값이 비어있으면 true, 하나라도 있으면 false
	      System.out.println("6-----------");
	      System.out.println(al.size());
	      al.remove(1);
	      System.out.println("7-----------");
	      System.out.println(al);
	      System.out.println("8-----------");
	      System.out.println(al.size());
	      
	      al.add(3.14);
	      al.add("apple");
	      al.add(new A(-1,-2));
	      A a=new A(1,2);
	      al.add(a);
	      System.out.println(al);      

	}
}
