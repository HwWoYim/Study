package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) {
		File f = new File("C:\\0607_YIM\\resource\\Hello.txt");
		// 해당 경로에 위치하는 파일이 존재하는지 체크하기!
		// 그리고 해당 파일이 경로에 존재하지 않으면 새로 만들어줌 -> FNE을 줄이는데에 도움이 된다.
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("로그: 파일 객체 생성 완료");
		}
		
		String msg = "";
		try {
			FileInputStream fis = new FileInputStream(f);
			
			int data;
			while((data=fis.read()) != -1) {
				msg += (char)data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(msg);
		int res = Integer.parseInt(msg);
		//문자열 -> 정수
		res++;
		System.out.println(res);
	}
}
