package class04;
// 내 첫번 째 코드
import java.util.Random;

class Pocketmon{
	Random rd = new Random();
	String name;
	int level;
	int exp;

	void action() {
		System.out.println(name + "가(이) " + "공격!");
		this.hit();
	}
	void hit() {
		int hitChance = rd.nextInt(100)+1; 
		if(hitChance<80) {
			System.out.println("공격 성공!");
			int exp = rd.nextInt(201)+10;
			this.exp += exp;
			System.out.println(exp + "경험치 상승");
			while(this.exp>=100) {
				this.exp -= 100;
				level++;
			}
			System.out.println("레벨: " + level + " / 잔여경험치: " + this.exp);
		}
		else { 
			System.out.println("공격 실패!");
			level--;
			System.out.println("레벨: " + level + " / 잔여경험치: " + exp);
			if(level < 1) {
				return;
			}
		}
	}
	Pocketmon(String name){
		this.exp = 0;
		this.level = rd.nextInt(5)+5;
		System.out.println("Game Start\nlevel : " + level);
	}
}
	class Thunder extends Pocketmon{
		@Override
		void action() {
			super.action();
		}

		public Thunder() {
			super("피카츄");
		}
	}
	
	class Fire extends Pocketmon{
		public Fire() {
			super("파이리");
		}
		@Override
		public String toString() {
			return "파이리가 불꽃공격!";
		}
	}
public class Test02 {


	public static void main(String[] args) {
		
		Thunder p1 = new Thunder();
		p1.action();
		p1.action();
		p1.action();
		System.out.println(p1);
		Fire p2 = new Fire();
		System.out.println(p2);




	}
}
