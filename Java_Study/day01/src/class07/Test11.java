package class07;

public class Test11 {
	public static void main(String[] args) {
		
		int num = 0;
		num = num +1;
		System.out.println("num : " + num);
		num += 1;
		System.out.println("num : " + num);
		num++;	// 증감연산자 -> 후위 증감연산자
		System.out.println("num : " + num);
		++num;	// 증감연산자 -> 전위 증감연산자
		System.out.println("num : " + num);

		
		int a = 10, b = 12;
		int c = a++;	// 연산자 우선순위
		// 후위 증감연산자의 순위가 아주아주 매우 낮음
		int d = ++a;
		System.out.println("a :" + a);
		System.out.println("c :" + c);
		System.out.println("d :" + d);
		
		int num1 = 10;
		int num2 = 20;
		int res = num1++ + ++num2;
		System.out.println(num1+ " ㅣ " + num2 + " ㅣ " + res);
		
		
	}
}
