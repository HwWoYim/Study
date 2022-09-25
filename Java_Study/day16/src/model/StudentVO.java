package model;

// VO => 기본 생성자
// DB 데이터 -> Java
// 이름,점수
// PK
public class StudentVO {
	private int num; // PK
	private String name;
	private int score;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
	public void startModel() {
		
	}
	
	
	// DB에서 Java로 데이터를 불러오는 것과 같은 역할
//	public void startModel() {
//		this.name="아무무";
//		this.num=1001;
//		this.score=90;
//	}
}
