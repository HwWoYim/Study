package class04;

// 웹 개발
// 게시판 프로그램
// 쇼핑몰 프로그램
// +sns

class Board{
	int num;
	String writer;
	String reg;
	String title;
	String content;
	int cnt;
	int fav;
	Board(int num, String writer, String reg, String title, String content, int cnt, int fav){
		this.num =num;
		this.writer = writer;
		this.reg = reg;
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.fav = fav;
		// this == 내 객체안의
		// this.num == 내 객체 안의 num변수 == 멤버변수
		
	}
}
public class Test07 {
	public static void main(String[] args) {
		Board b1 = new Board(1,"홍길동","6월 15일", "연습", "ㅈㄱㄴ", 0 ,0);
		
		
	}
}
