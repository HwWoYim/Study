package class07;

public class Test09 {
	public static void main(String[] args) {
		// 연산자
		// 대입 연산자
		// 산술 연산자
		
		int a = 10, b = 20;
		int num = a+b;	// 두 가지 액션을 한번에 처리할 수 없음
		// 연산자 우선순위 의심해보기
		// 대입 연산자의 우선 순위가 낮다
		
		double score = (10+20+31) * 1.0 / 3;
		// 가독성을 위해 코드의 내용을 잘 이해하자. ex) 과목이 만약 3개여서 3으로 나누는데 3.0개는 어색하니까
		System.out.println(score);
		
		System.out.println(10 / 3);
	}
}
