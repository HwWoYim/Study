package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Work02 {

	public static void main(String[] args) {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String user = "yim";
		final String passwd = "1234";
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		final String sql_selectOne = "SELECT * FROM GOODS WHERE NUM="+num;
		String goods = null;
		Connection conn = null;
		Statement stmt = null;
		
		
			try {
				Class.forName(driverName);
				
				conn = DriverManager.getConnection(url,user,passwd);
				
				stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql_selectOne);
				while(rs.next()) {
					System.out.println("이름: " + rs.getString("NAME"));
					System.out.println("나이: " + rs.getInt("PRICE"));
					System.out.println("재고: " + rs.getInt("CNT"));
					System.out.println("카테고리 " + rs.getInt("CATEGORY"));
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
