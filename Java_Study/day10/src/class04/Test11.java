package class04;

class Person{
	String name;
	void hello() {
		System.out.println("안녕하세요!");
	}
	Person(String name){
		this.name = name;
	}
}
class Student extends Person{
	int score;
	void hello() {	
		System.out.println("*^^*");
	}
	Student(String name, int score){
		super(name);
		this.score = score;
	}
	@Override
	public String toString() {
		return this.name + "학생: " + this.score + "점";
	}
}
public class Test11 {
	
	public static void main(String[] args) {
		Student s = new Student("아무무", 100);
		s.hello();
		System.out.println(s);
	}

}
