package class02;

class Student{
	String name;
	int level;
	int score;
	
	void show() {
		System.out.println(this.name + ": LV." + this.level + " SCORE: " + this.score);
	}
	Student(String name){
		this(name, 1, 0);
	}
	Student(String name, int level){
		this(name, level, 0);
	}
	Student(String name, int level, int score){
		this.name = name;
		this.level = level;
		this.score = score;
		System.out.println(this.name + "생성완료!");
	}
	

	
}

public class Test04 {

	public static void main(String[] args) {
		
		Student stu1 = new Student("홍길동");
		Student stu2 = new Student("아리", 20);
		Student stu3 = new Student("티모", 21, 95);
		
		stu1.show();
		stu2.show();
		stu3.show();
	}
}
