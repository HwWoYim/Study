package class01;

// 1. 요구사항(조건)을 파악
// 2. 클래스 전체적인 구조 : 멤버변수, 메소드, 생성자
// 3. 로직 구현
class Card {
	String name; // 멤버벼수
	int money;
	boolean flag;
	int limit; // 멤버변수

	void pay(int money) {
		// A만큼 결제해야하고, 총 누적사용량(B)에 더해서 새로 저장
		// B = B + A
		// B += A => 복합대입연산자
		if (flag && this.money + money > this.limit) {
			this.alert();
			return;
		}
		this.money += money;
		System.out.println(this.name + "님 결제완료. 누적사용금액 " + this.money + "원 입니다.");
	}

	void alert() {
		System.out.println(this.name + "님, 제한금액을 초과하여 사용할 수 없습니다!");
	}

	Card(String name) {
		this(name, -1); // limit이 -1이라는게 논리적으로 말이 안되기 때문에 -1로 작성할 수 있다.
		this.flag = false;
	}

	Card(String name, int limit) {
		this.name = name;
		this.flag = true;
		this.money = 0; // 가독성을 위해 초기화를 해줍시다.
		this.limit = limit;
	}

	@Override
	public String toString() {
		String msg = this.name + "님 현재까지 사용한 금액은";
		msg += this.money + "원 입니다. 제한금액 ";
		if (flag) {
			msg += "O: " + this.limit + "원";
		} else {
			msg += "X";
		}
		return msg;
	}
	@Override
	public boolean equals(Object obj) {
		// 1. 매개변수에 name변수가 없는 타입을 input으로 받으면 안되지 않을까?
		// 2. name에 빨간줄은 왜 뜨는 걸까
		
		// 비교대상 너, Card가 될 수 있는 개체야?
		// 혹시 Card가 될 수 없다면 .. 넌 무조건 false야
		if(obj instanceof Card) {
			// 객체 instanceof 클래스
			// == 객체가 클래스가 될 수 있어?
			Card card=(Card)obj;	// 명시적 형변환, 타입 캐스팅(다운 캐스팅)
			if(this.name.equals(card.name) ) {
				return true;
			}
		}
		return false;
	}

}

class CreditCard extends Card { // 처음 오류는 부모의 기본 생성자가 없기 때문에
	int cnt;

	@Override
	void alert() {
		super.alert();
		this.cnt++;
		System.out.println("총 [" + this.cnt + "]회 경고");
	}

	public CreditCard(String name, int limit) {
		super(name, limit); // 부모클래스에 기본생성자가 없으니까 super()은 안됨. 부모가 가지고 있는 생성자를 호출하여 사용할 예정

		this.cnt = 0;
	}
}
class BusCard extends Card{
	int age;
	int check() {
		int fare = 0;
		if(12<this.age && this.age<20) {
			fare=1000;
		}
		else if(19<this.age && this.age<66) {
			fare=2000;
		}
		return fare;
	}
	// 오버라이딩 : 상속관계에서 메소드 시그니처가 같을 때 함수를 재정의 해야합니다.
	// 오버로딩 : 상속관계xxx / 메소드 시그니쳐가 다를 때 함수명 중복정의 허용
	void pay() {	// 오버로딩
		// 나이에 맞게 교통요금을 결제
		// 근데 기존의 결제는 pay(???)로 진행했음
		this.pay(this.check());
	}
	public BusCard(String name, int age) {
		this(name, age, 0);
		this.flag = false;
	}
	public BusCard(String name, int age, int limit) {
		super(name, limit);
		if(this.age<0 || 200<this.age) {
			this.age = 20;
		}
		this.age = age;
	}

}

public class Test01 {
	public static void main(String[] args) {

		Card c3 = new Card("홍길동");
		Card c1 = new Card("홍길동");

		// == : 연산자 -> 원시타입에 활용
		// .equals() : Object가 제공하는 메서드
		if(c1.equals(c3)) {
			System.out.println("같다!");
		}
		else {
			System.out.println("다르다!");
		}
		System.out.println("----------------------------------");

		  Card c2=new Card("아리",5000);
	      c1.pay(100000);
	      c2.pay(3000);
	      c2.pay(4000);
	      System.out.println(c1);
	      System.out.println(c2);


		CreditCard cc = new CreditCard("아이폰", 2000);
		cc.pay(9000);
		cc.pay(3000);
		System.out.println(cc);
		System.out.println("----------------------------------");

		BusCard bc1 = new BusCard("삼성", 13, 5000);
		BusCard bc2 = new BusCard("LG", 250);
		bc1.pay();
		bc2.pay();
		System.out.println(bc1);
		System.out.println(bc2);

	}
}
