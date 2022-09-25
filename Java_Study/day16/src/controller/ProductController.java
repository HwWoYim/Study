package controller;

import model.ProductDAO;
import model.ProductVO;
import view.ProductView;

public class ProductController {
	ProductDAO model;
	ProductView view;
	public ProductController() {
		model=new ProductDAO();
		view=new ProductView();
	}
	public void startApp() {
		while(true) {
			view.startView();
			if(view.action==1) {
				ProductVO vo=new ProductVO();
				view.func1(model.selectAll(vo));
			}
			else if(view.action==2) {
				ProductVO vo=new ProductVO();
				int num=view.func2(model.selectAll(vo)); /// PK입력이라고 생각하고 진행해볼게요!!! :D
				///// 사용자가 먹고싶은 메뉴의 번호를 입력했는데,
				///// C에서 [view.action]
				/*
				C에서는 사용자가 입력한 메뉴의 번호를 view.action으로 참조가능하고,
				M은 pk를 입력받으면 상품객체를 줄 준비가 되어있습니다.
				 */

				vo.setNum(num);
				ProductVO data=model.selectOne(vo);
				if(data==null) {
					continue;
				}
				vo.setCnt(-2);
				System.out.println("로그1: "+vo);

				// pk를 넣으면 해당하는 상품을 반환하는 M의 selectOne()메서드
				boolean flag=model.update(vo);
				// M은 반환받은(==사용자가 선택한) 객체의 재고를 --
				ProductVO data2=model.selectOne(vo);
				int cnt=vo.getCnt();
				// 구매한 개수
				int price=data2.getPrice();
				int total=cnt*price*-1;
				System.out.println("로그: 총 결제 금액은: "+total+"원");

				/// model.update(model.selectOne(view.action+100));
				if(flag) {
					view.funcT(vo);
				}
				else {
					view.funcF();
				}
			}
			else if(view.action==3) {
				view.func3();
				break;
			}
			
			else if(view.action==1234) {
				// 관리자 모드
				while(true) {
					view.admin_func1();
					if(view.action==1) {
						ProductVO vo = new ProductVO();
						view.admin_func2();
						String name=view.admin_func3();
						int price=view.admin_func4();
						int cnt=view.admin_func5();
						if(model.insert(vo)) {
							view.admin_func6();
						}
						else {
							view.admin_func7();
						}
					}
					else if(view.action==2) {
						ProductVO vo = new ProductVO();
						view.admin_func8();
						view.func1(model.selectAll(vo));
						int num=view.admin_func9();
						num+=100;
						int cnt=view.admin_func5();
						if(model.update(vo)) {
							view.admin_func6();
						}
						else {
							view.admin_func7();
						}
					}
					else if(view.action==3) {
						view.admin_func10();
						int num=view.admin_func9();
						ProductVO vo = new ProductVO();
						if(model.delete(vo)) {
							view.admin_func6();
						}
						else {
							view.admin_func7();
						}
					}
					else if(view.action==4) {
						view.func3();
						break;
					}
				}
			}
			 
		}
	}
}
