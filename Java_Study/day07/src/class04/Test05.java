package class04;

class Person{
	String name;
	int age;
	// 생성자가 아무것도 정의되어 있는 것이 없다면, 기본 생성자를 제공해줌.
	// 생성자를 1개 이상 정의하면, 더 이상 기본 생성자가 제공되지 않습니다.
	Person(){
		this.name = "무명";
		this.age = 1;
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	// 함수명 중복 : 생성자 오버로딩

	void showInfo() {
		System.out.println(name + "님은 " + age + "살 입니다.");
	}
} 

public class Test05 {
	public static void main(String[] args) {

		Person p1 = new Person("홍길동", 21);
		Person p2 = new Person();	// 인자가 없는 생성자 == 기본(디폴드) 생성자

		p1.showInfo();
		p2.showInfo();

	}
}
