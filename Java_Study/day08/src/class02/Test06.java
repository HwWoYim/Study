package class02;

import javax.swing.plaf.synth.SynthOptionPaneUI;

class Card {
	String name;
	int limit;
	static int bal;

	void use() {

		this.use(10000);

	}

	void use(int money) {
		System.out.print(money + "원 사용: ");
		if (money > this.limit) {
			System.out.print("한도초과!");
		} else if (bal - money < 0) {
			System.out.print("잔액부족!");
		} else {
			bal -= money;
		}
		System.out.println(" 남은 금액 " + bal + "원");
	}

	// 모듈화: 동일한 기능을 하나의 함수로 묶는 것
	void showInfo() {
		System.out.println(name + "님[남은금액: " + bal + "원]");
	}

	Card(String name) {
		this(name, 200000);
	}

	Card(String name, int limit) {
		this.name = name;
		this.limit = limit;
	}
}

public class Test06 {

	public static void main(String[] args) {
		// 홍길동씨는 최초에 20만원 보유
		Card card1 = new Card("홍길동");
		Card card2 = new Card("홍길동", 20000);
		Card.bal = 200000;

		Card.bal = 200000;

		card1.use(); // 10000원 사용: 남은 금액 190000원
		card1.use(100000); // 100000원 사용: 남은 금액 90000원
		card2.use(50000); // 50000원 사용: 한도초과! 남은 금액 90000원
		card2.use(); // 10000원 사용: 남은 금액 80000원
		card1.use(90000); // 90000원 사용: 잔액부족! 남은 금액 80000원

		card1.showInfo(); // 홍길동님[남은금액: 80000원]
		card2.showInfo(); // 홍길동님[남은금액: 80000원]
	}

}