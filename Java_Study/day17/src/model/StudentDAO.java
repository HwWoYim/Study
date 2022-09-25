package model;

import java.util.ArrayList;

public class StudentDAO {
	ArrayList<StudentVO> datas; // DB
	private int pk;

	public StudentDAO() {
		datas = new ArrayList<StudentVO>();
		pk = 1001;

		// 샘플(초기) 데이터
		StudentVO vo = new StudentVO();
		vo.setName("홍길동");
		vo.setNum(pk++);
		vo.setScore(50);
		datas.add(vo);
	}

	public boolean insert(StudentVO vo) {
		try {
			vo.setNum(pk++);
			datas.add(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("	로그: insert()에서 확인되지않은 예외발생!");
			return false;
		}
	}

	public boolean update(StudentVO vo) {
		for (StudentVO data : datas) {
			if (data.getNum() == vo.getNum()) {
				data.setScore(vo.getScore());
				return true;
			}
		}
		return false;
	}

	public boolean delete(StudentVO vo) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getNum() == vo.getNum()) {
				datas.remove(i);
				return true;
			}
		}
		return false;
	}

	public StudentVO selectOne(StudentVO vo) {
		for (StudentVO data : datas) {
			if (data.getNum() == vo.getNum()) {
				return data;
			}
		}
		return null;
		/*
		 * for(int i=0;i<datas.size();i++) { if(datas.get(i).getNum()==vo.getNum()) {
		 * return datas.get(i); } } return null;
		 */
	}

	public ArrayList<StudentVO> selectAll(StudentVO vo) {
		if (vo.getName() != null) {
			ArrayList<StudentVO> datas = new ArrayList<StudentVO>();
			for (int i = 0; i < this.datas.size(); i++) {
				if (this.datas.get(i).getName().equals(vo.getName())) {
					datas.add(this.datas.get(i));
				}
			}
			return datas;
		}

		return datas;
	}
}
