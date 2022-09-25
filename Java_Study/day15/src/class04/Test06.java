package class04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test06 {

	public static void main(String[] args) {
		 final String path="C:\\0607_YIM\\resource\\";
	      try {
	         FileInputStream fis=new FileInputStream(path+"tm.png");
	         FileOutputStream fos=new FileOutputStream(path+"tm - 복사본.png");
	         
	         byte[] buff=new byte[1000];
	         int len;
	         while((len=fis.read(buff)) != -1) {	//fis.read(buff) =>>>> byte를 읽어들여 len에 저장
	            fos.write(buff,0,len);	// 읽어들인 byte 0부터 len까지
	         }
	         fos.flush();
	         fos.close();
	      } catch (Exception e) {
	    	  System.out.println("문제발생!!!!!");
	      } finally {
	         System.out.println("이미지 파일 복사-붙여넣기 완료");
	      }
	}
}
