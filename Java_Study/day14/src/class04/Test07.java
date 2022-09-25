package class04;

//[동기화]
//: 공유자원을 어떤 스레드가 점유하고있을때,
// 다른 스레드의 접근을 막는 것
class Person implements Runnable{
Ticketting t=new Ticketting();
@Override
public void run() {
   t.pay();
}
}
class Ticketting{
static int ticket=2; // 클래스 변수==공유자원
synchronized void pay() {
   if(ticket>0) {
      System.out.println(Thread.currentThread().getName()+"구매성공!");
      ticket--;
   }
   else {
      System.out.println(Thread.currentThread().getName()+"구매실패ㅠㅠㅠ");
   }
   System.out.println("남은티켓: "+ticket);
}
}
public class Test07 {
public static void main(String[] args) {
   Person person=new Person();
   Thread t1=new Thread(person,"홍길동");
   Thread t2=new Thread(person,"아무무");
   Thread t3=new Thread(person,"티모");
   
   t1.start();
   t2.start();
   t3.start();
}
}