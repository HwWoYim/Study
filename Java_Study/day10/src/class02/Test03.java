package class02;

// 접근제어자, 접근자
//접근제어자
class Student {
	private String name;
	private int score;
	// getter,setter
	// : private으로 직접접근할수없는 멤버변수의 값을
	// 출력하거나(getter), 변경(값대입)하기위해서(setter) 사용

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		this.score = score;
	}



	void showInfo() {
		System.out.println(this.name + " " + this.score);
	}

	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(this.name + "학생 입력완료!");
	}
}

public class Test03 {

	public static void main(String[] args) {

		Student[] data = new Student[2];
		data[0] = new Student("홍길동", 30);
		data[1] = new Student("아무무", 80);

		for (int i = 0; i < data.length; i++) {
			data[i].showInfo();
		}

	}

}