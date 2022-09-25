package class07;
	// 종현님 코드
class Card {
	   String name; // 카드 사용자
	   int money; // 현재까지 사용한 금액
	   boolean flag; // 제한 금액 여부
	   int limit; // 제한 금액
	   
	   void pay(int money) { // money만큼 결제
	      if(flag) { // 누적 사용금액 > 제한 금액 --> 경고 문자 출력
	         if(this.money + money > this.limit) {
	            this.alert();   // --> 경고 문자 출력
	            return;
	         }
	      }
	      this.money += money;
	   }

	   void alert() { // 경고 문자 출력
	      System.out.println("제한금액을 초과하여 사용할 수 없습니다!");
	   }
	   Card(String name) { 
	      this(name, -1); // -1 : 제한 금액 없음
	   }
	   Card(String name, int limit) {
	      this.name = name;
	      this.money = 0;
	      this.limit = limit;
	      this.flag = limit >= 0 ? true : false; // 음수 입력 --> 제한 금액 없음
	   }
	   @Override
	   public String toString() {
	      String msg = this.flag ? "제한 금액 O : " + this.limit + "원" : "제한 금액 X"; 
	      return name +"님 현재까지 사용한 금액은 " + this.money + "원입니다. " + msg;
	   }
	}

	class CreditCard extends Card {
	   int cnt; // 제한 금액을 초과하는 결제 횟수를 카운팅
	   @Override
	   void alert() {
	      cnt++;
	      System.out.println("제한 금액을 초과하여 사용할 수 없습니다. [총 " + cnt +"회 경고]");
	   }
	   CreditCard(String name, int limit) {
	      super(name, limit);
	      this.cnt = 0;
	   }
	}

	class BusCard extends Card{
	   int age; // 카드 사용자의 나이

	   int check() {
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
	   void pay() { // 카드 사용자의 나이에 맞게 결제
	      super.pay(this.check());
	   }
	   BusCard(String name, int age) {
	      this(name ,age, -1); // -1 : 제한 금액 없음
	   }
	   BusCard(String name, int age, int limit) {
	      super(name, limit);
	      this.age = age;
	   }
	   @Override
	   public String toString() {
	      String msg = this.flag ? "제한 금액 O : " + this.limit + "원" : "제한 금액 X"; 
	      return this.name +"님(" + this.age + "세) 현재까지 사용한 금액은 " + this.money + "원입니다. " + msg;
	   }


	}


	public class Test01 {

	   public static void main(String[] args) {
	      Card c = new Card("가나다", 20000);
	      c.pay(9000);
	      c.pay(13000);
	      System.out.println(c);

	      CreditCard cc = new CreditCard("홍길동", 15000);
	      cc.pay(5000);
	      cc.pay(6000);
	      cc.pay(4000);
	      cc.pay(10000);
	      cc.pay(10000);
	      System.out.println(cc);
	      BusCard bc1 = new BusCard("으악", 14);
	      bc1.pay();
	      bc1.pay();
	      System.out.println(bc1);
	      BusCard bc2 = new BusCard("임꺽정", 21, 10000);
	      bc2.pay();
	      bc2.pay();
	      System.out.println(bc2);
	   }

	}