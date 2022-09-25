package class04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test04 {

	public static void main(String[] args) {
		final String path1 = "C:\\0607_YIM\\resource\\";	//상수화
		final String path2 = ".txt";	//상수화
		
		try {
			FileOutputStream fos = new FileOutputStream(path1 + "test2" + path2,true);
			// 해당 경로에 파일이 없다면, 새로 생성!
			// 해당 경로에 파일이 있다면, 덮어쓰기가 됨!
			// -> 오버로딩된 생성자를 활용하여 2번째 인자를 true로 설정하면 이어쓰기가 가능!
			fos.write(65);	// 아스키 코드 =>>>> 'A'
			fos.flush();	// 버퍼를 비운다
			fos.close();	// 사용한 시스템 자원을 반납하고 출력 스트립 닫아준다
		} catch (Exception e) {
			System.out.println("파일 작성 중 문제발생!!!");
		} finally {
			System.out.println("fos객체를 통해서 파일객체 작성완료");
		}
		
		
	}
}
