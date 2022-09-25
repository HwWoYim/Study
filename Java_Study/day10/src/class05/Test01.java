package class05;

class Card {
	String name; // 카드 사용자
	int money; // 현재까지 사용한 금액
	boolean flag; // 제한금액 여부 -> T / F
	int limit; // 제한금액

	void pay(int money) {
		if (flag) {
			if (this.limit < this.money + money) {
				alert();
				return;
			}
		}
		this.money += money;

	}

	void alert() {
		System.out.println("제한금액을 초과하여 사용할 수 없습니다!");
	}
	Card(String name) {
		this(name, 0);
		flag = false;
	}
	Card(String name, int limit) {
		this.name = name;
		this.limit = limit;
		this.flag = true;
	}
	@Override
	public String toString() {
		String msg = null;
		if(flag) {
			msg = "제한금액 O: " + this.limit + "원";
			return this.name + "님 현재까지 사용한 금액은 " + this.money + "입니다." + msg;
		} else {
			return this.name + "님 현재까지 사용한 금액은 " + this.money + "입니다. 제한금액 X";
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class CreditCard extends Card {
	int cnt; // 제한금액을 초과하는 결제 횟수를 카운팅

	void pay(int money) {
		super.pay(money);
	}
	@Override
	void alert() {
		cnt++;
		System.out.println("제한금액을 초과하여 사용할 수 없습니다!  [총 " + cnt + "회 경고]");
	}
	CreditCard(String name, int limit) {
		super(name, limit);
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class BusCard extends Card {
	int age; // 카드 사용자의 나이

	int check() { // 카드사용자 나이가 ~12 0원 / 13~19 1_000원 / 20~65 2_000원 / 66~ 0원 을 반환
		if(this.age < 0 || this.age > 200) { // 나이는 0~200까지만 유효
	         return 2000; // 그 외의 값은 20살의 비용(2000원)
	      }
	      else if(this.age < 13 || 65 < this.age) {
	         return 0;
	      }
	      else if(this.age < 20) {
	         return 1000;
	      }
	      else {
	         return 2000;
	      }
	   }
	void pay() { // 사용자 나이에 맞게 결제
		super.pay(this.check());
	}
	BusCard(String name, int age) {
		super(name);
		this.age = age;
		flag = false;
	}

	BusCard(String name, int age, int limit) {
		super(name, limit);
		this.age = age;
		flag = true;
	}
	@Override
	public String toString() {
		String msg = null;
		if(flag) {
			msg = "제한금액 O: " + this.limit + "원";
			return this.name + "님(" + this.age + "세) 현재까지 사용한 금액은 " + this.money + "입니다." + msg;
		} else {
			return this.name + "님(" + this.age + "세) 현재까지 사용한 금액은 " + this.money + "입니다. 제한금액 X";
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		Card card = new Card("홍길동", 2000);
		card.pay(1000);
		System.out.println(card);
		Card card2 = new Card("홍길동2");
		card2.pay(2000);
		System.out.println(card2);
		System.out.println("--------------------------------------------");
		
		CreditCard cC = new CreditCard("아무개", 10000);
		cC.pay(5000);
		cC.pay(5000);
		cC.pay(5000);
		cC.pay(5000);
		System.out.println(cC);
		System.out.println("--------------------------------------------");
		
		BusCard bC = new BusCard("안녕", 25);
		bC.pay();
		System.out.println(bC);
		BusCard bC2 = new BusCard("안녕", 36, 50000);
		bC2.pay();
		System.out.println(bC2);
	}
}
