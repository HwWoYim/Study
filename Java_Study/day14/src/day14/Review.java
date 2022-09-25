package day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Student{
   String name;
   int score;
   Student(String name){
      this.name=name;
      Random random=new Random();
      this.score=random.nextInt(101);
      System.out.println(this.name+"학생 "+this.score+"점으로 등록완료!");
   }
   @Override
   public String toString() {
      return name + "학생 " + score + "점";
   }
}
public class Review {
   public static void main(String[] args) {
      Map<Integer,Student> data=new HashMap<Integer,Student>();

      final int PK_START=1001; // 상수화
      final int PK_MAX=2000;
      int PK=PK_START;
      // 프로그램이 부여

      Scanner sc=new Scanner(System.in);
      while(true) {
         System.out.println();
         System.out.println("1.등록 2.출력 3.삭제 4.종료");
         System.out.print("입력) ");
         int act=sc.nextInt();
         if(act==1) {
            System.out.print("학생이름입력) ");
            String name=sc.next();
            data.put(PK,new Student(name));
            PK++;
         }
         else if(act==2) {
            if(data.size()==0) {
               System.out.println("저장된 데이터가 없습니다!");
               continue;
            }
            for(int i=PK_START;i<PK;i++) {
               Student stu=data.get(i);
               if(stu==null) {
                  continue;
               }
               System.out.println(i+"번: "+stu);
            }
         }
         else if(act==3) {
            if(data.size()==0) {
               System.out.println("삭제할 데이터가 없습니다!");
               continue;
            }
            System.out.print("삭제할 번호입력) ");
            int key=sc.nextInt();

            /*
            if(!data.containsKey(key)) {
               System.out.println("해당번호의 학생이 존재하지않습니다!");
               continue;
            }         
             */

            if(key<PK_START || PK_MAX<key) {
               System.out.println("번호를 다시 확인하시고 입력해주세요!");
               continue;
            }
            Student stu=data.remove(key);
            System.out.println("로그: "+stu);
            // ★ 로그
            //  -> 에러원인 찾고, 그 해결방안 설명하기
            if(stu==null) {
               System.out.println("존재하지않는 학생번호입니다.");
               continue;
            }            
            System.out.println(stu+"삭제완료!");
         }
         else if(act==4) {
            System.out.println("프로그램 종료...");
            break;
         }
         else {
            System.out.println("다시 입력해주세요!");
         }
      }
   }
}