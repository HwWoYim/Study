package class02;

import java.util.ArrayList;
import java.util.Scanner;
class Drink{

	String name;	// 이름
	int price;		// 가격
	int cnt;		// 제거	-> true = 음료가 있다, false = 음료가 없다
	
	void use() {
		if(this.check()) {
			System.out.println(this.name + " 구매완료");
			this.cnt--;
		} else {
			System.out.println(this.name +" 구매실패");
			return;
		}
	}

	boolean check() {
		if(this.cnt<1) {
			System.out.println("선택하신 음료의 재고가 없습니다.");
			return false;
		}
		return true;
	}
	Drink(String name, int price){
		this(name, price, 0);
	}
	Drink(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return this.name + " " + this.price + "원 [" + this.cnt + "]";
	}

}
public class Test04_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Drink> data = new ArrayList<Drink>(); 
		data.add(new Drink("사이다", 800));
		data.add(new Drink("콜라", 900, 10));
		data.add(new Drink("옥수수수염차", 1500, 30));
		System.out.println("원하시는 음료를 선택하여 주세요.\n1.사이다 2.콜라 3.옥수수수염차 4.종료");
		System.out.print("음료선택>>> ");
		int pick = sc.nextInt()-1;
		data.get(pick).use();;
		System.out.println(data.get(pick));


	}
}
