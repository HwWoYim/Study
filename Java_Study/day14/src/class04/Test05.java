package class04;

import java.util.Scanner;

// +)
// 나만의 예외만들기
class MyException extends Exception{
   // 멤버변수 메세지 값을
   // 반드시 설정해서 만들수있게!
   // -> 생성자: 멤버변수 값을 초기화할때
   private String message;
   MyException(String message){
      this.message=message;
   }
   public String getMessage() {
      return message;
   }

   // 1.오버라이딩
   // -> 기존의 메서드가 마음에들지않을때, 재정의
   // 2. toString()
   // -> 출력
   // 3. 제네릭
   // -> 컬렉션 생성할때, 어떤 타입을 다룰지를 강제
   // 4. abstract
   // -> 추상클래스: 부모클래스를 만들고싶을때
   // -> 추상메서드: 내 자식의 오버라이딩을 강제하고싶을때
   // 5. super
   // -> 부모의 것을 가져올때
   // 6. 인터페이스
   // -> 상속관계가 아닌 두개의 클래스 사이의 메서드 시그니쳐를 정의할때
   // 7. 오버로딩
   // -> 함수가 원래 있었고, 그거랑 비슷한(같은) 기능을 새로 만들때
   // 8. static
   // -> 객체와 무관하게
   // 9. void
   // -> 타입없음 無
}
public class Test05 {
   public static void main(String[] args) {

      MyException me=new MyException("범위에 맞는 나이를 입력해주세요!");

      Scanner sc=new Scanner(System.in);
      try {
         System.out.print("나이입력) ");
         int age=sc.nextInt();
         if(age<0 || 200<age) {
            // 예외를 일부러 발생시켜야하는 상황
            throw me;
         }
      }
      catch(MyException e) {
         System.out.println(e.getMessage());
      }


   }
}