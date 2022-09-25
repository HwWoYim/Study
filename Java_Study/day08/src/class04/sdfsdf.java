package class04;

import java.util.Random;
import java.util.Scanner;

public class sdfsdf {

   static void f1(int[] data) {
      for(int i=0;i<data.length;i++) {
         System.out.print(data[i]+" ");
      }
   }

   static int[] f2(int num) {
      Random rand = new Random();
      int[] lotto = new int[num];

      for(int i=0;i<num;i++) {
         lotto[i]=rand.nextInt(50)+1;
         for(int j=0;j<i;j++) {
            if(lotto[i]==lotto[j]) {
               i--;
               break;
            }
         }
      }
      return lotto;   
      
   }


   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);


      System.out.print("정수입력: ");
      int num = sc.nextInt();

      int[] lotto = f2(num);
      f1(lotto);
      
      

   }

}