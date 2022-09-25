package class03;

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
}
public class class04 {
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
            int menu;
            while(true) {
               System.out.print("메뉴입력: ");
               menu=sc.nextInt();
               if(0<menu && menu<=data.size()) {
                  break;
               }
               System.out.println("없는 메뉴번호입니다! 확인후 다시 입력해주세요!");
            }
            data.get(menu-1).use();
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