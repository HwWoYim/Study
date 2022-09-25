package class01;

class Car{
	String name; // 멤버변수,속성,필드,어트리뷰트(애트리뷰트),...
	int speed;
	int maxSpeed;
	// ★오버로딩
	void speedUp() { // 멤버함수,메서드
		// 1. 기본형
		// 2. 기능구현
		// 3. input,output이 올바른지 체크
		this.speed+=10;
		if(this.speed>this.maxSpeed) {
			this.speed=this.maxSpeed;
			System.out.println("과속!");
		}
	}
	void speedUp(int speed) {
		// 기본형->기능구현->input,output이 올바른지 체크
		this.speed+=speed;
		if(this.speed>this.maxSpeed) {
			this.speed=this.maxSpeed;
			System.out.println("과속!");
		}
	}
	void showInfo() {
		System.out.println(this.name+"님의 현재 차량 상태: ["+this.speed+"/"+this.maxSpeed+"]");
	}
	// 생성자 오버로딩
	Car(String name){
		// 1. 인자가 가장 많은 생성자만 놔두고,
		// 2. 다른 생성자에서 1번의 생성자를 재사용
		this(name, 0, 120);
	}
	Car(String name,int speed,int maxSpeed){
		this.name=name;
		this.speed=speed;
		this.maxSpeed=maxSpeed;
	}
}

public class Test01 {

	public static void main(String[] args) {

		Car car1=new Car("홍길동",0,200); // 기본(디폴트) 생성자
		// 멤버변수가 내가 원하는 값대로 초기화되지 xxx
		// -> 생성자를 사용하는 이유: 멤버변수를 원하는 값으로 초기화 가능 + "강제"
		Car car2=new Car("아리");

		car1.speedUp(130);
		car2.speedUp(130);

		car1.showInfo();
		car2.showInfo();



	}

}
