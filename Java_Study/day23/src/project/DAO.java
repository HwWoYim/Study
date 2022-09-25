package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert = "INSERT INTO GENIE VALUES((SELECT NVL(MAX(GID),0)+1 FROM GENIE),?,?,?)";	// 서브쿼리를 활용
	final String sql_selectAll = "SELECT * FROM GENIE"; // GENIE 테이블 전체 출력
	public boolean insert(VO vo) { // insert문
		conn=JDBCUtil.connect(); // JDBCUtil 클래스로 DB와 연결
		try {
			pstmt=conn.prepareStatement(sql_insert); // 여러번 수행할 때 빠른속도를 자랑하는 prepareStatement에 인자를 부여
			pstmt.setString(1, vo.getTitle()); // set으로 vo의 노래제목 저장
			pstmt.setString(2, vo.getSinger()); // set으로 vo의 가수이름 저장
			pstmt.setString(3, vo.getAlbum()); // set으로 vo의 앨범이름 저장
			pstmt.executeUpdate(); //insert(DDL)문에서 실행되는거니 update로
		} catch (SQLException e) { // SQL오류가 발생한다면?
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; // false 리턴
		} finally { // 무조건 실행되는 부분
			JDBCUtil.disconnect(pstmt, conn); // DB와 연결해제
		}
		return true;
	}
	public ArrayList<VO> selectAll(VO vo){ // ArrayList<VO>리턴타입의 selectAll
		ArrayList<VO> datas=new ArrayList<VO>(); // 새로운 VO타입 배열 객체 생성
		conn = JDBCUtil.connect(); // DB와 연결
		try {
			pstmt=conn.prepareStatement(sql_selectAll); // 모든 데이터를 보여줄 것이니 prepareStatement
			ResultSet rs = pstmt.executeQuery(); // SELECT문에 대한 결과값을 저장하는 ResultSet, pstmt의 데이터를 executeQuery()로 조회할 것
			while(rs.next()) { // 다음 데이터가 없을 때까지 반복
				VO data = new VO();
				data.setGid(rs.getInt("gid"));
				data.setTitle(rs.getString("title"));
				data.setSinger(rs.getString("singer"));
				data.setAlbum(rs.getString("album"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn); // DB와 연결해제
		}
		return datas;
	}
	
	
}
