package class02;

abstract class Po{
	abstract void fun1();	// 각각의 몬스터마다 고유한 액션 -> 오버라이딩 => "강제"
	abstract void fun2();	// 각각의 몬스터마다 고유한 액션 -> 오버라이딩 => "강제"
	// -> 추상메소드 : 메소드바디{ }를 갖지 않는다
	//				   어차피 오버라이딩이 강제되었다면, 동적바인딩에 의해 자식 메소드만 출력될 것이기 때문에
	// 추상메소드를 하나 이상 가지면 해당 클래스는 추상클래스여야 한다
	void fun3() {
		System.out.println("도망");
	}
	void fun4() {
		System.out.println("밥먹기");
	}
}
class Pika extends Po{

	@Override
	void fun1() {
		System.out.println("백만볼트!");
	}

	@Override
	void fun2() {
		System.out.println("피카츄가 방어했다!");
	}
	
}

public class Test03 {
	public static void main(String[] args) {
		
	}
}
