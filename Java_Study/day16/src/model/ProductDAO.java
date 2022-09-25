package model;

import java.util.ArrayList;

// CRUD
public class ProductDAO {
	// DB를 대체하는 컬렉션(배열리스트)
	ArrayList<ProductVO> datas;
	private int pk=101;
	///// DAO를 사용할텐데, DAO가 생성되면 그 즉시
	///// datas도 생성되게끔하고싶어요~
	///// == DAO의 멤버변수인 datas도 값을 가질수있게 만들고싶어요~
	public ProductDAO() {
		datas=new ArrayList<ProductVO>();

		// 초기 데이터
		// 샘플 데이터
		ProductVO vo=new ProductVO();
		vo.setCnt(2);
		vo.setName("콜라");
		vo.setNum(pk++);
		vo.setPrice(1100);
		datas.add(vo);
	}

	// 관리자
	// 새로운 음료 추가
	// 음료 재고 추가
	// 기존 음료 삭제

	// 사용자(서비스)
	// 음료 출력
	// 음료 구매
	public ArrayList<ProductVO> selectAll(ProductVO vo) { // getAll()
		// V측에서 무엇을 필요로할지 고려!
		return datas;
	}
	public ProductVO selectOne(ProductVO vo) { // getOne()
		for(int i=0;i<datas.size();i++) {	// datas 배열리스트의 길이보다 i가 작다면
			if(vo.getNum()==datas.get(i).getNum()) {	// vo객체의 getNum과 datas의 get i번째의 getNum과
				return datas.get(i);	// 같다면 datas.get(i번째)를 리턴하라
			}
		}
		return null;	// 같지 않다면 null값을 리턴하라
	}

	// 1. 결제: -1
	// 2. 결제: -N
	// 3. 결제완료시 총 금액 => C에서 update()마치고, selectOne()
	// 4. 재고추가 +N
	public boolean update(ProductVO vo) {	// 변경 메소드
		for(ProductVO data:datas) {	// foreach문 -> ProductVO타입 data변수 : 배열
			if(data.getNum()==vo.getNum()) {	// data의getNum과 vo객체의 getNum과
				
				data.setCnt(data.getCnt()+vo.getCnt());	// 같다면 data의 getCnt와 vo객체의 getCnt를 더한 값을 data의 setCnt에 저장해주어라.
				// M: 결제를 할지, 재고추가를 할지 난 모름
				//   -값         +값
				return true;	// return값은 true
			}
		}
		return false; // return 값은 false
	}

	public boolean insert(ProductVO vo) {	// 추가 메소드
		try {
			vo.setNum(pk++);	// vo의setNum에 pk증감식한 값 대입
			datas.add(vo);		// datas에 vo객체 저장
		}catch(Exception e) {	// 예외처리
			e.printStackTrace();	// 에러발생 경로와 에러메세지를 표현
			return false;	// 에러 발생시 return값은 false
		}
		return true;	// 에버 발생하지 않았을 시 return 값 true
	}

	public boolean delete(ProductVO vo) {	// 삭제 메소드
		for(int i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==vo.getNum()) {
				datas.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean update(int num, int cnt) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert(String name, int price, int cnt) {
		// TODO Auto-generated method stub
		return false;
	}
}
