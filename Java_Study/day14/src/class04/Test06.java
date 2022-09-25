package class04;

//[스레드]
//: 기사,컴퓨터구조,프로세스,...
class Th1 extends Thread{
	// 스레드는 작업을 처리하는 주체(대상)
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("클래스로 만든 스레드"+i);
		}
	}   
}
class Th2 implements Runnable{
	// 인터페이스의 모든 메서드는 abstract 추상메서드
	// 추상메서드는 오버라이딩을 강제
	// -> 인터페이스가 가지는 "강제성"!
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("인터페이스로 만든 스레드"+i);
		}
	}   
}
public class Test06 {
	public static void main(String[] args) {

		Th1 t1=new Th1();

		Th2 t2=new Th2();
		Thread t3=new Thread(t2);

		t1.start(); // 스레드야, 너의 일을 해!
		t3.start();   // run()

	}
}