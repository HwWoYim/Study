package class01;

import java.util.ArrayList;
import java.util.Random;

public class Test02_1 {

   public static void main(String[] args) {
	   // "제네릭" -> 컬렉션에 저장될 데이터들의 타입(자료형)을 "강제"
	   // => 모든 컬렉션에는 제네릭을 추가해서 사용!!!
	   // "자료형"
      ArrayList al=new ArrayList();

      Random random=new Random();
      while(al.size()<5) {
         int num=random.nextInt(9)+1;
         if(num%2==1) {
            al.add(num);
         }
      }
      
      System.out.println(al);
      
      int sum=0;
      for(int i=0;i<al.size();i++) {
         sum+=(int)al.get(i);
      }
      System.out.println("sum= "+sum);
      
      double res=sum*1.0/2;
      System.out.println("sum/2= "+res);
   }

}