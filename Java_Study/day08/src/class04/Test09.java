package class04;
import java.util.Random;
import java.util.Scanner;

class RdNumber {
   Random rd = new Random();

   RdNumber(int num) {
      int[] arr = new int[num]; // 랜덤한 숫자를 넣을 배열

      for (int i = 0; i < num; i++) { // 랜덤한 숫자 부여 for문 시작
         int randNum = rd.nextInt(50) + 1;
         arr[i] = randNum;
         for (int j = 0; j < i; j++) { // 중복 제거 for문 시작
            if (arr[j] == arr[i]) {
               i--;
               break;
            }
         } // 중복 제거 for문 종료
      } // 랜덤한 숫자 부여 for문 종료
      for (int i = 0; i < arr.length; i++) { // 랜덤 숫자 출력 for문
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

}

public class Test09 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.print("정수 입력>>> ");
         int num = sc.nextInt(); // 출력하고자 하는 갯수 입력
         if (num < 1 || num > 50) {
            System.out.println("숫자의 범위를 초과하였습니다. \n다시 입력해주세요!");
            continue; // 1보다 작은 숫자 입력시 반복문 재시작
         }

         RdNumber user = new RdNumber(num);

         if (num >= 1) {
            System.out.println(num + "개의 랜덤한 숫자가 출력 되었습니다~^^");
            break;
         }
      }

   }
}