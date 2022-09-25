package class04;

class Student{
	// 생성자는 함수의 한 종류
	// -> 생성자는 객체화 할 때만 쓰니까, output : 객체
	// 함수 3요소 -> 메소드 시그니쳐
	String name;
	int num;
	int score;
	Student(String name, int num, int score){
		this.name = name;
		this.num = num;
		this.score = score;
	}
	void showInfo() {
		System.out.println(name + "학생은 " + num + "번: " + score + "점");
	}
}


public class Test04 {
	public static void main(String[] args) {
		// new연산자는 붕어빵을 구워내는 행위
		Student stu1 = new Student("아무개", 27, 100);
		Student stu2 = new Student("홍길동", 101, 95);

		//		stu2.name = "홍길동";	// 멤버변수 초기화 작업
		//		stu2.num = 101;
		//		stu2.score = 95;

		stu1.showInfo();
		stu2.showInfo();

	}
}
