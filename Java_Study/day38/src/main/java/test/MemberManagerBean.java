package test;

import java.util.ArrayList;

public class MemberManagerBean{
	ArrayList<MemberBean> datas = new ArrayList<MemberBean>();
	
	public boolean insert(MemberBean mb) {
		datas.add(mb);
		return true;
	}
	
	public ArrayList<MemberBean> selectAll(MemberBean mb){ //유지보수때문에 매개변수 생성
		return datas;
	}
	
	public MemberBean selectOne(MemberBean mb) {
		for(MemberBean v:datas) {
			if(mb.getUname().equals(v.getUname())) {
				return v;
			}
		}
		return null;
	}
	
	
	
	
	
	
}
