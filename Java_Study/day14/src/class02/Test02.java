package class02;

import java.util.Scanner;

public class Test02 {
   public static void main(String[] args) {
      int[] data= {1,2,3};
      Scanner sc=new Scanner(System.in);
      System.out.print("인덱스넘버 입력) ");
      int num=sc.nextInt();
      try {
         System.out.println("AAA");
         // 예외가 발생할만한 구간을 설정
         System.out.println(data[num]);
         // 예외발생즉시 try->catch로 즉시 이동
         System.out.println("BBB");
      }
      catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("0이상 "+data.length+"미만까지만 입력해주세요");
         // 예외처리는
         // 1- 무슨 에러였는지(개발자)
         // 2- 어떻게 해야하는지(사용자)
         e.printStackTrace();
      }
   }
}