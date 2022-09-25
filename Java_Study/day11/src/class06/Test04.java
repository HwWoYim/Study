package class06;

import java.util.Random;
import java.util.Scanner;

// 내 두번째 코드
class Pokemon{
	String name;
	int level;
	int exp;
	String attack() {
		return "ㅁㅁㅁ";
	}

	void action() {
		System.out.println(this.name + "이(가) " + this.attack() + "공격!");
		if(this.check()) {
			this.success();
		} else {
			this.fail();
		}
	}
	boolean check() {
		Random rd = new Random();
		int num = rd.nextInt(5);
		if(num == 0) {
			return false;
		}
		return true;
	}
	void success() {
		Random rd = new Random();
		System.out.println("공격성공!");
		int exp = rd.nextInt(201)+10;
		this.exp += exp;
		System.out.println(exp + "경험치 획득!");
		while(this.exp>=100) {
			this.exp -= 100;
			this.level++;
		}
	}
	void fail() {
		System.out.println("공격실패!");
		if(this.level < 1) {
			System.out.println("제일 낮은 레벨입니다.");
			return;
		}
		this.level--;
	}
	Pokemon(String name){
		Random rd = new Random();
		this.name = name;
		this.level = rd.nextInt(5)+5;
		this.exp = 0;
	}
	@Override
	public String toString() {
		action();
		String msg=this.name+" ";
		msg+="Lv."+this.level+" ";
		msg+="["+this.exp+"/100]";
		return msg;

	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("sdfsdf");
		// obj -> main() 에서 실제로는 문자열(String)을 보냈지만 Object로 받았기 때문에, 현재 상자가 Object
			if(this.name.equals(obj.toString())) {	// .toString이 생략되었던 거였다
				return true;
		}
		return  false;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////
class Pikachu extends Pokemon{


	@Override
	String attack() {
		return "백만볼트 공격!";
	}

	Pikachu() {
		super("피카츄");
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////
class Pairi extends Pokemon{

	
	@Override
	String attack() {
		return "불꽃공격!";
	}

	Pairi(){
		super("파이리");
	}

}

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pokemon[] data = new Pokemon[3];	// 객체 배열(클래스명이 자료형자리에 들어가게 됨)
		data[0] = new Pikachu();
		data[1] = new Pikachu();
		data[2] = new Pairi();
		int cnt = 0;
		System.out.print("포켓몬을 입력 : ");
		String Pokemon = sc.next();
			for (int i = 0; i < data.length; i++) {
				if(Pokemon.equals(data[i].name)) {	// 잘안나오는 코드, getter를 훨씬 많이 씀
					// 포켓몬 객체가 직접 equals()수행
					//
					cnt++;
				}
			}
			if(cnt>0) {
				System.out.println(Pokemon + "는(은) " + cnt + "마리 존재합니다.");
			} else {
				System.out.println(Pokemon + "는(은) 없습니다..");
			}
			
		Pokemon p1 = new Pokemon("디그닥");
		System.out.println(p1);
		System.out.println(p1);
		System.out.println(p1);

		Pikachu p2 = new Pikachu();
		System.out.println(p2);
		System.out.println(p2);
		System.out.println(p2);

		Pairi p3 = new Pairi();
		System.out.println(p3);
		System.out.println(p3);
		System.out.println(p3);
		System.out.println(p3);
		System.out.println(p3);
	}
}
