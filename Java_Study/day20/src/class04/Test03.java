package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03 {
	public static void main(String[] args) {

		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String user = "yim";
		final String passwd = "1234";

		final String sql_selectOne = "SELECT NAME FROM STUDENT WHERE NUM=3";
		final String sql_selectAll = "SELECT * FROM STUDENT";
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(driverName);

			conn = DriverManager.getConnection(url, user, passwd);

			stmt = conn.createStatement();

			/*
			 * ResultSet rs=stmt.executeQuery(sql_selectOne); if(rs.next()) {
			 * System.out.println("이름: "+rs.getString("NAME")); // rs.get자료형("칼럼명"); } else
			 * { System.out.println("결과없음"); } rs.close();
			 */

			ResultSet rs = stmt.executeQuery(sql_selectAll);
			// forEach, Iterator, ...
			while (rs.next()) {	// 이 값을 자바에서 저장하려면 ArrayList에 저장하면 된다.
				System.out.println("이름: " + rs.getString("NAME"));
				System.out.println("나이: " + rs.getInt("AGE"));
				System.out.println("성적: " + rs.getInt("SCORE"));
				System.out.println();
			}
			rs.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}