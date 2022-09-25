package class06;

public class Test06 {
	public static void main(String[] args) {
		
		// 학생부 프로그램
		int[] stu = {10,20,30,40,50};
		
		// . -> 함수/키워드 : "반환값"
		for (int i = 0; i < stu.length; i++) {	// 요소의 개수(배열의 길이)
			System.out.println("학생 " + (i+1) + "번의 성적은 " + stu[i] + "점");
		}
		
		
	}
}
