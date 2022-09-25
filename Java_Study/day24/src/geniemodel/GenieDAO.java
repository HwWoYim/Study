package geniemodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenieDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert = "INSERT INTO GENIE VALUES((SELECT NVL(MAX(NUM),0)+1 FROM GENIE),?,?,?)"; // 서브쿼리를 활용
	final String sql_selectAll = "SELECT ROWNUM AS 순위, GENIE. * FROM GENIE ORDER BY ROWNUM ASC"; // GENIE 테이블 전체 출력, ORDER BY 오름차순
//	final String sql_selectAll = "SELECT * FROM GENIE WHERE NAME LIKE '%'||?||'%'"; // GENIE 테이블 전체 출력, ORDER BY 오름차순
	final String sql_selectOne = "SELECT * FROM GENIE WHERE NUM=?";
	final String sql_delete = "DELETE FROM GENIE WHERE NUM=?";
	final String sql_update = "UPDATE GENIE SET NAME=?, ARTIST=?, ALBUM=? WHERE NUM=?";
	

	public boolean insert(GenieVO vo) { // insert
		conn = JDBCUtil.connect(); // JDBCUtil 클래스로 DB와 연결
		try {
			pstmt = conn.prepareStatement(sql_insert); // 여러번 수행할 때 빠른속도를 자랑하는 prepareStatement에 인자를 부여
			pstmt.setString(1, vo.getName()); // set으로 vo의 노래제목 저장
			pstmt.setString(2, vo.getArtist()); // set으로 vo의 가수이름 저장
			pstmt.setString(3, vo.getAlbum()); // set으로 vo의 앨범이름 저장
//			pstmt.executeUpdate(); // insert(DDL)문에서 실행되는거니 update로
			
			int res = pstmt.executeUpdate();
			if(res==0) {
				System.out.println("로그 : 노래추가 실패");
				return false;
			}
		} catch (SQLException e) { // SQL오류가 발생한다면?
			e.printStackTrace();
			return false; // false 리턴
		} finally { // 무조건 실행되는 부분
			JDBCUtil.disconnect(pstmt, conn); // DB와 연결해제
		}
		return true;
	}

	public boolean delete(GenieVO vo) { // delete
		conn = JDBCUtil.connect(); // DB연결
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getNum()); // pstmt의 첫번째 바인딩변수에 vo의 getGid값 저장
//			pstmt.executeUpdate(); // INSERT, UPDATE, DELETE 일때 사용
			int res = pstmt.executeUpdate();
			if (res == 0) {
				System.out.println("로그 : 노래삭제 실패");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	public boolean update(GenieVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getAlbum());
			pstmt.setInt(4, vo.getNum());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	public ArrayList<GenieVO> selectAll(GenieVO vo) { // ArrayList<VO>리턴타입의 selectAll
		ArrayList<GenieVO> datas = new ArrayList<GenieVO>(); // 새로운 VO타입 배열 객체 생성
		conn = JDBCUtil.connect(); // DB와 연결
		try {
			pstmt = conn.prepareStatement(sql_selectAll); // 모든 데이터를 보여줄 것이니 prepareStatement
			ResultSet rs = pstmt.executeQuery(); // SELECT문에 대한 결과값을 저장하는 ResultSet, pstmt의 데이터를 executeQuery()로 조회할 것
			while (rs.next()) { // 다음 데이터가 없을 때까지 반복
				GenieVO data = new GenieVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setArtist(rs.getString("artist"));
				data.setAlbum(rs.getString("album"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn); // DB와 연결해제
		}
		return datas;
	}
//	final String sql_selectOne = "SELECT * FROM GENIE WHERE NUM=?";
	public GenieVO selectOne(GenieVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getNum());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setArtist(rs.getString("artist"));
				vo.setAlbum(rs.getString("album"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
}
