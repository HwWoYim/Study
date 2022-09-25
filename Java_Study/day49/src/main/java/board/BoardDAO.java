package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberVO;
import util.JDBCUtil;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	// DeleteM 에서 게시물이 있는지 없는지 확인
	final String sql_selectOneB="SELECT * FROM BOARD WHERE MID=?";
	final String sql_selectOneR="SELECT * FROM REPLY WHERE MID=?";
	// 모든 게시물에 갯수 제한을 두고 내림차순으로 보여준다.
	final String sql_selectAll="SELECT * FROM (SELECT * FROM BOARD ORDER BY BID DESC) WHERE ROWNUM <=?";
	final String sql_selectAll_M="SELECT * FROM (SELECT * FROM BOARD WHERE MID=? ORDER BY BID DESC) WHERE ROWNUM <=?";
	// 모든 게시물에는 댓글이 작성될 수 있다.
	final String sql_selectAll_R="SELECT * FROM REPLY WHERE BID=? ORDER BY RID DESC";
					// final String sql_selectAllB = "SELECT * FROM BOARD WHERE MID = ? AND ROWNUM <= ? ORDER BY BID DESC";
	// 게시물 추가
	final String sql_insert="INSERT INTO BOARD(BID,MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),?,?)";
	// 댓글 추가
	final String sql_insert_R="INSERT INTO REPLY(RID,MID,BID,RMSG) VALUES((SELECT NVL(MAX(RID),0) +1 FROM REPLY),?,?,?)";
	// BID번째 게시물 삭제
	final String sql_delete="DELETE FROM BOARD WHERE BID=?";
	// RID번째에 댓글 삭제
	final String sql_delete_R="DELETE FROM REPLY WHERE RID=?";
	// BID번째 좋아요 +1 업데이트
	final String sql_update="UPDATE BOARD SET FAVCNT=FAVCNT+1 WHERE BID=?";

//	public ArrayList<BoardSet> selectB(MemberVO mvo,BoardVO bvo){
//		ArrayList<BoardSet> datas=new ArrayList<BoardSet>();
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement(sql_selectAllB);
//			pstmt.setString(1, mvo.getMid());
//			pstmt.setInt(2, bvo.getCnt());
//			ResultSet rs=pstmt.executeQuery();
//			while(rs.next()) {
//				BoardSet bs=new BoardSet();
//
//				BoardVO boardVO=new BoardVO();
//				boardVO.setBid(rs.getInt("BID"));
//				boardVO.setMid(rs.getString("MID"));
//				boardVO.setMsg(rs.getString("MSG"));
//				boardVO.setFavcnt(rs.getInt("FAVCNT"));
//				boardVO.setRcnt(rs.getInt("RCNT"));
//
//				bs.setBoardVO(boardVO);
//				ArrayList<ReplyVO> rList=new ArrayList<ReplyVO>();
//				pstmt=conn.prepareStatement(sql_selectAll_R);
//				pstmt.setInt(1, rs.getInt("BID")); // 현재 BID
//				ResultSet rs2=pstmt.executeQuery();
//				while(rs2.next()) {
//					ReplyVO replyVO=new ReplyVO();
//
//					replyVO.setBid(rs2.getInt("BID"));
//					replyVO.setMid(rs2.getString("MID"));
//					replyVO.setRid(rs2.getInt("RID"));
//					replyVO.setRmsg(rs2.getString("RMSG"));
//
//					rList.add(replyVO);
//				}
//				bs.setrList(rList);				
//
//				datas.add(bs);
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		return datas;
//	}
	// mid의 게시물
	public BoardVO selectOneB(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOneB);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				BoardVO data=new BoardVO();
				data.setMid(rs.getString("MID"));
				return data;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}      
		return null;
	}
	// mid의 댓글
	public ReplyVO selectOneR(ReplyVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOneR);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ReplyVO data=new ReplyVO();
				data.setMid(rs.getString("MID"));
				return data;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}      
		return null;
	}
	// 게시물 추가 - mid의 id명과 msg의 게시물 내용
	public boolean insert(BoardVO bvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, bvo.getMid());
			pstmt.setString(2, bvo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	// 게시물 삭제 - board의 pk값 bid번째 삭제
	public boolean delete(BoardVO bvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1,bvo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	// 댓글 추가 - mid의 id명, 댓글 달린 board의 bid번째, rmsg의 댓글 내용
	public boolean insertR(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_R);
			pstmt.setString(1, rvo.getMid());
			pstmt.setInt(2, rvo.getBid());
			pstmt.setString(3, rvo.getRmsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	// 댓글 삭제 - reply의 rid번째 댓글 삭제
	public boolean deleteR(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete_R);
			pstmt.setInt(1, rvo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	// 좋아요 - 몇번째 bid의 좋아요를 +1 해줄 것인지
	public boolean update(BoardVO bvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setInt(1, bvo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	// 비로그인상태 - 전체 게시물, 로그인 상태 - 내가 쓴 글 확인
	public ArrayList<BoardSet> selectAll(BoardVO bvo){ // 유지보수 용이
		ArrayList<BoardSet> datas=new ArrayList<BoardSet>();
		conn=JDBCUtil.connect();
		try {
			if(bvo.getMid() == null) { // 로그인 하지 않았을 때 전체보기
				pstmt=conn.prepareStatement(sql_selectAll);
				pstmt.setInt(1, bvo.getCnt());
			} else { // 로그인 하면 내가 쓴 글 보기
				pstmt=conn.prepareStatement(sql_selectAll_M);
				pstmt.setString(1, bvo.getMid());
				pstmt.setInt(2, bvo.getCnt());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardSet bs=new BoardSet();

				BoardVO boardVO=new BoardVO();
				boardVO.setBid(rs.getInt("BID"));
				boardVO.setFavcnt(rs.getInt("FAVCNT"));
				boardVO.setMid(rs.getString("MID"));
				boardVO.setMsg(rs.getString("MSG"));
				boardVO.setRcnt(rs.getInt("RCNT")); ///// rList.size();
				bs.setBoardVO(boardVO);
				// 모든 게시물에는 댓글이 달려있을 수 있으므로 댓글 은 if문이 아닌 곳에 로직작성
				ArrayList<ReplyVO> rList=new ArrayList<ReplyVO>();
				pstmt=conn.prepareStatement(sql_selectAll_R);
				pstmt.setInt(1, rs.getInt("BID")); // 현재 BID
				ResultSet rs2=pstmt.executeQuery();
				while(rs2.next()) {
					ReplyVO replyVO=new ReplyVO();

					replyVO.setBid(rs2.getInt("BID"));
					replyVO.setMid(rs2.getString("MID"));
					replyVO.setRid(rs2.getInt("RID"));
					replyVO.setRmsg(rs2.getString("RMSG"));

					rList.add(replyVO);
				}
				boardVO.setRcnt(rList.size());
				bs.setrList(rList);				

				datas.add(bs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
}
