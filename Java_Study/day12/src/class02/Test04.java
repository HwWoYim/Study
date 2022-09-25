package class02;

abstract class Official{ // (부모)추상클래스
   String name; // 이름
   int salary;  // 연봉
   String position;  // 직급

   abstract void action();  
   abstract void wear();  
   abstract void greet();  

   Official(String name, String position, int salary){  
      this.name=name;
      this.position=position;
      this.salary=salary;

   }
   @Override
   public String toString() {
      return "이름 : " + this.name + "\n직급 : " + this.position + "\n연봉 : " + this.salary;
   }
   
   
}

class Police extends Official{ // (자식)경찰클래스

   @Override
   void action() {

      System.out.println(this.name+this.position+", 범인검거!");
   }

   @Override
   void wear() {
      System.out.println(this.name+this.position+"이(가) 경찰복을 입습니다.");
   }

   @Override
   void greet() {
      System.out.println(" 충성! ");
   }

   Police(String name, String position, int salary){
      super(name,position,salary);
   }

}
class FireFighter extends Official{ // (자식)소방관클래스

   @Override
   void action() {
      System.out.println(this.name+this.position+", 화재진압!");
   }

   @Override
   void wear() {
      System.out.println(this.name+this.position+"이(가) 방화복을 입습니다.");
   }
   @Override
   void greet() {
      System.out.println(" 안전! ");
   }

   FireFighter(String name, String position, int salary){
      super(name,position,salary);
   }

}
class Soldier extends Official{ // (자식)군인클래스

   @Override
   void action() {
      System.out.println(this.name+this.position+", 사격훈련!");

   }

   @Override
   void wear() {
      System.out.println(this.name+this.position+"이(가) 군복을 입습니다.");

   }

   @Override
   void greet() {
      System.out.println(" 단결! ");

   }

   Soldier(String name, String position, int salary){
      super(name,position,salary);
   }

}
public class Test04 {

   public static void main(String[] args) {

      Police police = new Police("임환욱","경감",5000);
      FireFighter firefighter = new FireFighter("김종현","소방장",6000);
      Soldier soldier = new Soldier("김수빈","중위",5000);

      police.action();
      police.wear();
      police.greet();

      System.out.println();
      
      firefighter.action();
      firefighter.wear();
      firefighter.greet();

      System.out.println();
      
      soldier.action();
      soldier.wear();
      soldier.greet();

      System.out.println();
      
      System.out.println(police);
      System.out.println();
      System.out.println(firefighter);
      System.out.println();
      System.out.println(soldier);
      
      
      
   }

}