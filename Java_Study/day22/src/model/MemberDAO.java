package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	// CRUD
	// 회원가입 - C
	// 로그인 - R
	// 로그아웃
	// 마이페이지 내 정보 확인
	// 마이페이지 내 정보 변경 - U
	// 회원탈퇴 - D
	final String sql_login="SELECT * FROM MEMBER WHERE MID=?";
	public MemberVO login(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_login);
			pstmt.setString(1,vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("mpw").equals(vo.getMpw())) {
					MemberVO data = new MemberVO();
					data.setMid(rs.getString("mid"));
					data.setMname(rs.getString("mname"));
					data.setMpw(rs.getString("mpw"));
					System.out.println("로그 : 로그인성공!");
					return data;
				}
				System.out.println("로그 : 비밀번호 불일치로 로그인 실패...");
				return null;
			}
			System.out.println("로그 : 회원정보 없음으로 로그인 실패...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		// 1. DB에 해당 아이디가 있는가?
		// 2. DB에서 찾은 그 해당 정보에 맞는 비밀번호인가?
		return null;
	
	}
}
