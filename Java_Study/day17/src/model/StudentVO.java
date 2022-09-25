package model;

public class StudentVO {
	private int num;	//-> pk
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
		// TODO Auto-generated method stub
		return "StudentVO [name= " + this.name + " Score = " + this.score + "]";
	}
	
}
