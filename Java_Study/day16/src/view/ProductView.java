package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

public class ProductView {
	Scanner sc=new Scanner(System.in);
	public int action;
	public void startView() {
		while(true) { // 유효성 검사 -> 꼼꼼하게 작업해보기!
			System.out.println("=== 자판기 ===");
			System.out.println("1.메뉴확인 2.구매 3.종료");
			System.out.print("입력) ");
			action=sc.nextInt();
			if((1<=action&&action<=3) || action==1234) {
				break;
			}
			System.out.println("범위외입력!");
		}
	}
	public void func1(ArrayList<ProductVO> datas) {
		for(int i=0;i<datas.size();i++) {
			System.out.println(datas.get(i));
		}
	}
	public int func2(ArrayList<ProductVO> datas) {
		for(int i=0;i<datas.size();i++) {
			System.out.print(datas.get(i).getNum()+"번메뉴 ");
			if(datas.get(i).getCnt()==0) {
				System.out.println("X");
				continue;
			}
			System.out.println(datas.get(i).getName());
		}
		
			System.out.print("메뉴입력) ");
			int menu=sc.nextInt();
			return menu;
			
	}
	public void funcT(ProductVO vo) {
		System.out.println(vo.getName()+" 구매완료!");
	}
	public void funcF() {
		System.out.println("상품이 존재하지않거나, 재고가 없습니다...");
	}
	public void func3() {
		System.out.print("프로그램이 종료됩니다");
		for(int i=0;i<5;i++) {
			System.out.print(".");
			try {
				Thread.sleep(1); // 1000==1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	// 1~3 메뉴를 보여주는 출력문구
	// 음료추가
	// 음료이름입력
	// 음료가격입력
	// 음료재고입력
	// 수행이 완료되었습니다!
	// 수행실패! 다음에 다시 이용해주세요...
	// 음료재고추가
	// 번호입력
	// 음료삭제
	public void admin_func1() { // 1~4 메뉴를 보여주는 출력문구
		while(true) { 
			System.out.println("=== 관리자 모드 ===");
			System.out.println("1.음료추가 2.재고추가 3.음료삭제 4.관리자모드 종료");
			System.out.print("입력) ");
			action=sc.nextInt();
			if(1<=action&&action<=4) {
				break;
			}
			System.out.println("범위외입력!");
		}
	}
	public void admin_func2() { // 음료추가
		System.out.println("음료추가 메뉴입니다.");
	}
	public String admin_func3() { // 음료이름입력
		System.out.print("음료 이름을 입력) ");
		String name=sc.next();
		return name;
	}
	public int admin_func4() { // 음료가격입력
		System.out.print("음료 가격을 입력) ");
		int price=sc.nextInt();
		return price;
	}
	public int admin_func5() { // 음료재고입력
		System.out.print("음료 재고를 입력) ");
		int cnt=sc.nextInt();
		return cnt;
	}
	public void admin_func6() { // 수행이 완료되었습니다!
		System.out.println("수행이 완료되었습니다!");
	}
	public void admin_func7() { // 수행실패! 다음에 다시 이용해주세요...
		System.out.println("수행실패! 다음에 다시 이용해주세요...");
	}
	public void admin_func8() { // 음료재고추가
		System.out.println("음료재고추가 메뉴입니다.");
	}
	public int admin_func9() { // 번호입력
		System.out.print("번호 입력) ");
		int num=sc.nextInt();
		return num;
	}
	public void admin_func10() { // 음료삭제
		System.out.println("음료삭제 메뉴입니다.");
	}
	
}
