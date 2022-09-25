package class06;
	// 아림님 코드
class Card {
	String name;
	int money;
	boolean flag;
	int limit;

	void pay(int money) {
		if (limit > 0) {
			flag = true;

			if (flag) { // true : 제한금액 o, false : 제한금액 x

				if (money > this.limit) {
					alert();
				} else {
					this.money += money;
				}
			}
		} else {
			this.money += money;

		}
	}

	void alert() {
		System.out.println("제한금액을 초과하여 사용할 수 없습니다!");
	}

	Card(String name) {
		this(name, 0);

	}

	Card(String name, int limit) {
		this.name = name;
		this.limit = limit;

	}

	@Override
	public String toString() {
		return this.name + "님 현재까지 사용한 금액은 " + this.money + "원입니다." + "제한금액 O : " + this.limit + "입니다.";
	}

}

class CreditCard extends Card {
	int cnt = 0;

	CreditCard(String name, int limit) {

		super(name, limit);

	}

	@Override
	void alert() {
		cnt++;
		System.out.println("제한금액을 초과하여 사용할 수 없습니다! [총 " + cnt + "회 경고]");

	}

}

class BusCard extends Card {
	int age;

	int check() {

		if (age <= 12) {
			return 0;
		} else if (age >= 13 && age <= 19) {
			return 1000;
		} else if (age >= 20 && age <= 65) {
			return 2000;
		} else {
			return 0;
		}

	}

	void pay() {
		this.money += check();
	}

	BusCard(String name, int age) {
		this(name, age, 0);
	}

	BusCard(String name, int age, int limit) {
		super(name, limit);
		this.age = age;
		if (age < 0 || age > 200) {
			this.age = 20;
		}
	}

}

public class Test02 {

	public static void main(String[] args) {
		CreditCard credit = new CreditCard("홍길동", 10000);
		credit.pay(20000);
		System.out.println(credit);
		credit.pay(10000);
		System.out.println(credit);
		credit.pay(10000);
		System.out.println(credit);
		credit.pay(10000);
		System.out.println(credit);

		BusCard buscard1 = new BusCard("홍길동", 21);
		buscard1.pay();
		System.out.println(buscard1);

		BusCard buscard2 = new BusCard("홍길동", 21, 10000);
		buscard1.pay();
		System.out.println(buscard1);
	}

}