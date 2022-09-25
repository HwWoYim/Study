package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {	// Exception 최상위 클래스로 바꿔야함ㅌ
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. DB에 연결
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String user = "yim";
		final String password = "1234";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			stmt.executeQuery("INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'장편소설',21800,120,'도서'");
			System.out.println("로그 : DB연결하여 쿼리문 실행완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
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
