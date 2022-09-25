package class04;

import java.util.ArrayList;
import java.util.Scanner;

class Drink{
	String name;
	int price;
	int cnt;
	void use() {
		if(!this.check()) {
			System.out.println(this.name+" 재고없음!");
			return;
		}
		this.cnt--;
		System.out.println(this.name+" 구매완료");
	}
	boolean check() {
		if(this.cnt>0) {
			return true;
		}
		return false;
	}
	Drink(String name,int price){
		this(name,price,0);
	}
	Drink(String name,int price,int cnt){
		this.name=name;
		this.price=price;
		this.cnt=cnt;
	}
	@Override
	public String toString() {
		return this.name + " " + this.price + "원 [" + this.cnt + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this.name.equals(obj.toString())) {
			return true;
		}
		return false;
	}

}
public class Test04 {
	public static void main(String[] args) {

		ArrayList<Drink> data=new ArrayList<Drink>();
		data.add(new Drink("콜라",900,10));
		data.add(new Drink("사이다",800));
		data.add(new Drink("웰치스",1200,2));
		System.out.println(data);

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.메뉴출력 2.메뉴입력 3.종료");
			System.out.print("입력: ");
			int act=sc.nextInt();

			if(act==1) {
				for(int i=0;i<data.size();i++) {
					System.out.println((i+1)+"번 메뉴: "+data.get(i));
				}
			}
			else if(act==2) {
				System.out.print("메뉴입력: ");
				String name=sc.next();
				boolean flag=true; // 제품이 없는 상태 T | 제품이 있는 상태 F
				for(int i=0;i<data.size();i++) {
					if(data.get(i).equals(name)) {
						data.get(i).use();
						flag=false;
					}
				}
				if(flag) {
					System.out.println(name+"는(은) 없습니다!");
				}
			}
			else if(act==3) {
				System.out.println("프로그램 종료...");
				break;
			}
			else {
				System.out.println("잘못된 act입력입니다!");
			}
		}











	}
}