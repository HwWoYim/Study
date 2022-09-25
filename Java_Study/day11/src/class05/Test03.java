package class05;
import java.util.Random;
// 강사님코드
class Pokemon{
   String name;
   int level;
   int exp;
   void action() {
      System.out.println(this.name+"이(가) ㅁㅁ공격!");
      if(this.check()) {
         this.success();
      }
      else {
         this.fail();
      }
   }
   boolean check() {
      Random rand=new Random();
      int num=rand.nextInt(5); // 성공 80% 실패 20%
      if(num==0) {
         return false;
      }
      return true;
   }
   void success() {
      Random rand=new Random();
      int exp=rand.nextInt(201)+10; // 10~210
      this.exp+=exp;
      while(this.exp>=100) {
         this.exp-=100;
         this.level++;
         System.out.println(this.name+", 레벨업!");
      }
      System.out.println(this.name+" 공격성공! 획득경험치: "+exp);
   }
   void fail() {
      System.out.println(this.name+" 공격실패...");
      if(this.level==1) {
         System.out.println("레벨은 1미만이 불가능합니다.");
         return;
      }
      this.level--;      
   }
   Pokemon(String name){
      this.name=name;
      Random rand=new Random();
      this.level=rand.nextInt(5)+5;
      this.exp=0;
   }
}
class Pikachu extends Pokemon{
   @Override
   void action() {
      System.out.println(this.name+"이(가) 백만볼트공격!");
      if(this.check()) {
         this.success();
      }
      else {
         this.fail();
      }
   }
   Pikachu(){
      super("피카츄");
   }
}
class Pairi extends Pokemon{
	@Override
	void action() {
		System.out.println(this.name+"이(가) 불꽃공격!");
		if(this.check()) {
			super.success();
		}
		else {
			super.fail();
		}
	}
	Pairi() {
		super("파이리");
	}
	@Override
	public String toString() {
		action();
		return name;
	}
	
}
public class Test03 {
   public static void main(String[] args) {

	   Pikachu p1 = new Pikachu();
	   System.out.println(p1);
	   Pairi p2 = new Pairi();
	   System.out.println(p2);
	   System.out.println(p2);
	   System.out.println(p2);
	   System.out.println(p2);
   }
}