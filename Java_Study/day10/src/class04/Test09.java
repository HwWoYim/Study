package class04;

class A{
	   void func1() {
	      System.out.println("A");
	   }
	}
	class B extends A{
	   // 상속관계에서 함수 재정의를 허용
	   // [오버라이딩]
	   // 인자의 개수,자료형 모두 같아야만한다!
	   void func1() {
	      System.out.println("B");
	   }
	}
	public class Test09 {
	   
	   // [오버로딩]
	   // 상속관계xxx
	   // 함수명 중복정의->인자의 개수,자료형 달라야만했다!
	   
	   public static void main(String[] args) {
	      A a=new A();
	      B b=new B();
	      
	      a.func1();
	      b.func1();
	   }
	}