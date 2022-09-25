package class05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// CRRUD
public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert="INSERT INTO WEBTOON VALUES((SELECT NVL(MAX(WID),0)+1 FROM WEBTOON),?)";
	final String sql_selectAll="SELECT * FROM WEBTOON";
	public boolean insert(VO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1,vo.getTitle());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public ArrayList<VO> selectAll(VO vo) {
		ArrayList<VO> datas=new ArrayList<VO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				VO data=new VO();
				data.setTitle(rs.getString("title"));
				data.setWid(rs.getInt("wid"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
}
