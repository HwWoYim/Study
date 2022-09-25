package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert="INSERT INTO STUDENT VALUES((SELECT NVL(MAX(SID),0)+1 FROM STUDENT),?,?)";
	final String sql_delete="DELETE FROM STUDENT WHERE SID=?";
	final String sql_update="UPDATE STUDENT SET SCORE=? WHERE SID=?";
	final String sql_selectAll="SELECT * FROM STUDENT WHERE NAME LIKE '%'||?||'%' ORDER BY SID ASC";
	final String sql_selectOne="SELECT * FROM STUDENT WHERE SID=?";

	public boolean insertStudent(StudentVO vo) {
		conn=JDBCUtil.connect();
		try {			
			pstmt=conn.prepareStatement(sql_insert);
			// stmt -> 일단 만들고, 직접 쿼리문(SQL문)을 메서드의 인자로 전달
			// pstmt -> 만들당시에 쿼리문(SQL문)을 전달하고, 이후에 값을 메서드의 인자로 전달

			/*
			pstmt.executeQuery(); // R selectOne() selectAll()
			pstmt.executeUpdate(); // CUD insert() update() delete()
			 */
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore());
			int res=pstmt.executeUpdate();
			System.out.println("	로그: insertStudent() 완료");
			if(res==0) {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}

		return true;
	}
	public boolean updateStudent(StudentVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getScore());
			pstmt.setInt(2, vo.getSid());
			int res=pstmt.executeUpdate();
			if(res==0) {
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
	public boolean deleteStudent(StudentVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getSid());
			int res=pstmt.executeUpdate();
			if(res==0) {
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
	public StudentVO selectOne(StudentVO vo) {
		conn=JDBCUtil.connect();
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getSid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				StudentVO data=new StudentVO();
				data.setName(rs.getString("NAME"));
				data.setScore(rs.getInt("SCORE"));
				data.setSid(rs.getInt("SID"));
				return data;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtil.disconnect(pstmt, conn);
		}		
	}
	public ArrayList<StudentVO> selectAll(StudentVO vo){
		ArrayList<StudentVO> datas=new ArrayList<StudentVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			pstmt.setString(1, vo.getName());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentVO data=new StudentVO();
				data.setName(rs.getString("NAME"));
				data.setScore(rs.getInt("SCORE"));
				data.setSid(rs.getInt("SID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
}
