package class04;

// [최상위 클래스 Object]
class Book extends Object{
	@Override
	public String toString() {
		return "책입니다.";
	}
	// 함수 재정의
	// 오버라이딩
	
}
public class Test10 {
	public static void main(String[] args) {
	
		Book b = new Book();
		
		System.out.println(b);
	}

}
