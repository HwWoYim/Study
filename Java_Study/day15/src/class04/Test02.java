package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		// [파일 입출력]
		File file=new File("C:\\0607_YIM\\resource\\test.txt");	// test.txt 파일을 받아오려한다.
		// C:\\0607_YIM\\resource\\ 이 경로에서 데이터를 주고 받을 것
		// 해당 경로에 위치하는 파일이 존재하는지 확인하고
		// 해당 파일이 없으면 새로 생성
		
		// 파일을 생성하는 작업
		try {
			file.createNewFile();	// boolean타입의 메소드(새로운 파일을 생성하는 메소드)
		} catch (IOException e) {	// IOException : In,Output 수행 중 문제 발생하면 해당 블록으로 이동
			System.out.println("파일객체생성 중 문제발생!!");
		} finally {
			System.out.println("로그: 파일객체생성완료");
		}

		System.out.println("----파일 읽기 시작점----");
		try {
			FileInputStream fis=new FileInputStream(file);	// 인자로 파일 객체, 또는 해당 파일 경로를 작성
			//FileInputStream fis=new FileInputStream("D:\\0607KIM\\resource\\test.txt");

			int data;
			while((data=fis.read()) != -1) {	// 파일의 내용의 끝을 모르니 while문. 마지막을 읽기 위해 -1
				System.out.print((char)data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----파일 읽기 완료----");
		}


	}
}
