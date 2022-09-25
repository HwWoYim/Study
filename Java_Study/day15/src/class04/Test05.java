package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test05 {

	public static void main(String[] args) {
		 final String path1="C:\\0607_YIM\\resource\\";	// 경로
	      final String path2=".txt";	// 확장자
	      
	      int sum=0;	// 총합을 넣을 변수 초기화
	      try {
	         FileInputStream fis=new FileInputStream(path1+"test"+path2);	// 해당 경로에 파일이 없으면 생성, 있으면 덮어씌우기
	         
	         int data;
	         while((data=fis.read())!=-1) {	// 파일의 끝을 모르니 while문 사용. 마지막을 읽기 위해 -1
	            System.out.println(data);
	            char ch=(char)data;	// char타입으로 형변환
	            String str="";
	            str+=ch;	// 형변환 한 것을 String 타입 변수에 대입
	            System.out.println(ch);
	            int num=Integer.parseInt(str);	// int타입으로 다시 형변환
	            sum+= num;	// 총합
	         }
	      } catch (Exception e) {	// 오류 발생한다면 해당 블록으로 이동
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("sum= "+sum);
	      
	      try {
	         FileOutputStream fos=new FileOutputStream(path1+"test"+path2);
	         fos.write(sum); // "sum= "+sum
	         // 자바 파일입출력 문자열
	         // FileReader FileWriter
	         fos.flush();
	         fos.close();
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	}
}
