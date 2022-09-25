//package model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import model.util.JDBCUtil;
//import model.vo.MemberVO;
//
//public class MemberDAO {
//	Connection conn;	// db연결
//	PreparedStatement pstmt;	// 텍스트 sql문 호출
//	public MemberVO selectOne(MemberVO vo) {
//		conn=JDBCUtil.connect();	// db연결
//		try {
//			pstmt=conn.prepareStatement("SELECT * FROM MEMBER WHERE MPK=?");
//			pstmt.setInt(1, vo.getMpk());
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()) {
//				MemberVO data=new MemberVO();
//				data.setMpk(rs.getInt("MPK"));
//				data.setName(rs.getString("NAME"));
//				data.setScore(rs.getInt("SCORE"));
//				return data;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return null;
//	}
//	public ArrayList<MemberVO> selectAll(MemberVO vo) {
//		ArrayList<MemberVO> datas=new ArrayList<MemberVO>();
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement("SELECT * FROM MEMBER");
//			ResultSet rs=pstmt.executeQuery();
//			while(rs.next()) {
//				MemberVO data=new MemberVO();
//				data.setMpk(rs.getInt("MPK"));
//				data.setName(rs.getString("NAME"));
//				data.setScore(rs.getInt("SCORE"));
//				datas.add(data);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return datas;
//	}
//	public boolean insert(MemberVO vo) {
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement("INSERT INTO MEMBER VALUES((SELECT NVL(MAX(MPK),0)+1 FROM MEMBER),?,?)");
//			pstmt.setString(1, vo.getName());
//			pstmt.setInt(2, vo.getScore());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return true;
//	}
//	public boolean update(MemberVO vo) {
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement("UPDATE MEMBER SET NAME=?,SCORE=? WHERE MPK=?");
//			pstmt.setString(1, vo.getName());
//			pstmt.setInt(2, vo.getScore());
//			pstmt.setInt(3, vo.getMpk());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return true;
//	}
//	public boolean delete(MemberVO vo) {
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement("DELETE FROM MEMBER WHERE MPK=?");
//			pstmt.setInt(1, vo.getMpk());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return true;
//	}
//}
//
//
//
//
//
//
