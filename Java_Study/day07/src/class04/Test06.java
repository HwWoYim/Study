package class04;

class Car {
	String name;
	int maxSpeed;
	Car(){
		this.name = "무명";
		this.maxSpeed = 200;
	}
	Car(String n){
		this.name = n;
		this.maxSpeed = 200;
		
	}
	Car(String n, int s){
		this.name = n;
		this.maxSpeed = s;
	}
	
	void show() {
		System.out.println(name + "님 자동차 최대속력: " + maxSpeed);
	}
}

public class Test06 {
	public static void main(String[] args) {
		
		Car c1 = new Car();
		Car c2 = new Car("홍길동", 120);
		Car c3 = new Car("임꺽정");
		
		c1.show();
		c2.show();
		c3.show();
	}
}
