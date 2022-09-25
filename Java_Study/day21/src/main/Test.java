package main;
// C
// V
// Client

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentDAO;
import model.StudentVO;

public class Test {

	public static void main(String[] args) {
		
		StudentDAO sDAO=new StudentDAO();

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("1.추가 2.목록 3.검색 4.변경 5.삭제 6.종료 7.이름검색");
			System.out.print("입력) ");
			int act=sc.nextInt();
			if(act==1) {
				System.out.print("학생이름입력) ");
				String name=sc.next();
				System.out.print("학생성적입력) ");
				int score=sc.nextInt();
				// [V]
				
				StudentVO vo=new StudentVO();
				vo.setName(name);
				vo.setScore(score);
				if(sDAO.insertStudent(vo)) {
					System.out.println("학생추가 완료되었습니다.");
				}
				else {
					System.out.println("학생추가 실패했습니다...");
				}
				// [C]
			}
			else if(act==2) {
				StudentVO vo=new StudentVO();
				ArrayList<StudentVO> datas=sDAO.selectAll(vo);
				if(datas.size()==0) {
					System.out.println("출력할 학생데이터가 없습니다...");
					continue;
				}
				System.out.println("===학생 목록===");
				for(StudentVO data:datas) {
					System.out.println(data);		
				}
			}
			else if(act==3) {
				// selectOne()
				// -> 2개이상xxx
				// => PK로 검색!
				System.out.print("학생번호입력) ");
				int sid=sc.nextInt();
				// [V]
				
				StudentVO vo=new StudentVO();
				vo.setSid(sid);
				vo=sDAO.selectOne(vo);
				if(vo==null) {
					System.out.println("검색실패...");
					continue;
				}
				System.out.println(vo);
				// [C]
			}
			else if(act==4) {
				System.out.print("학생번호입력) ");
				int sid=sc.nextInt();
				System.out.print("학생점수입력) ");
				int score=sc.nextInt();
				// [V]
				
				StudentVO vo=new StudentVO();
				vo.setSid(sid);
				vo.setScore(score);
				if(sDAO.updateStudent(vo)) {
					System.out.println("학생변경 완료되었습니다.");
				}
				else {
					System.out.println("학생변경 실패했습니다...");
				}
				// [C]
			}
			else if(act==5) {
				System.out.print("학생번호입력) ");
				int sid=sc.nextInt();
				// [V]
				
				StudentVO vo=new StudentVO();
				vo.setSid(sid);
				if(sDAO.deleteStudent(vo)) {
					System.out.println("학생삭제 완료되었습니다.");
				}
				else {
					System.out.println("학생삭제 실패했습니다...");
				}
				// [C]
			}
			else if(act==6) {
				break;
			}
			else if(act==7) { // selectAll()
				System.out.println("검색어입력");
				String str=sc.next();
				// [V]
				
				StudentVO vo=new StudentVO();
				vo.setName(str);
				ArrayList<StudentVO> datas=sDAO.selectAll(vo);
				// [C]
				
				if(datas.size()==0) {
					System.out.println("검색결과없음...");
					continue;
				}
				System.out.println("===학생 목록===");
				for(StudentVO data:datas) {
					System.out.println(data);		
				}
				// [V]
			}
		}

	}

}
