package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {
   public static void main(String[] args) {
      ArrayList<Integer> al=new ArrayList<Integer>();
      al.add(-1);
      al.add(0);
      al.add(1);
      al.add(2);
      al.add(3);
      System.out.println("로그: 배열리스트 확인: "+al);

      Scanner sc=new Scanner(System.in);
      while(true) {
         int res=10;
         try {
            System.out.print("정수입력) ");
            int num=sc.nextInt();

            res/=al.get(num);
         }
         catch(InputMismatchException e) {
            System.out.println("로그: 정수만 입력해주세요!");
            sc.nextLine();
            continue;
         }
         catch(IndexOutOfBoundsException e) {
            System.out.println("로그: 인덱스범위예외발생: "+e.getMessage());
            continue;
         }
         catch(ArithmeticException e) {
            System.out.println("로그: 예외발생: "+e.getMessage());
            continue;
         }
         catch(Exception e) {
            e.printStackTrace();
            System.out.println("로그: 미확인예외발생!");
         }
         System.out.println("결과= "+res);

         break;
      }
   }
}