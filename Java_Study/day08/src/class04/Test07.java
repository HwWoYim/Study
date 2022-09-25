package class04;

import java.util.Random;

class Person{
	String name;
	static int sand=100;
	boolean game() {
		Random random = new Random();
		int num=random.nextInt(20)+1;
		System.out.println(name+"님이 "+num+" 가져갑니다..");
		sand-=num;
		System.out.println("남은 모래: "+sand);
		System.out.println();
		if(sand<=0) {
			System.out.println(name+"님, 게임오버!");
			return true;
		}
		return false;
	}
	Person(String name){
		this.name=name;
	}
}

public class Test07 {

	public static void main(String[] args) {

		Person[] p = new Person[3];	// 객체 배열 안에 요소가 객체이다.
		
		p[0]=new Person("홍길동");
		p[1]=new Person("아리");
		p[2]=new Person("티모");

		int i = 0;
		while(true) {
			if(p[i].game()) {
				break;
			}
			i++;
			if(i==p.length) {
				i=0;
			}
		}

	}

}