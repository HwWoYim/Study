package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Work01 {

	public static void main(String[] args) {
		// driver load
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		// DB connect
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String user = "yim";
		final String password = "1234";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("제품명 입력>>> ");
			String name = sc.next();
			System.out.print("제품가격 입렵>>> ");
			int price = sc.nextInt();
			System.out.print("제품재고 입력>>> ");
			int cnt = sc.nextInt();
			System.out.println("카테고리 보기\n1.전자제품 2.음식 3.패션 4.취미");
			System.out.print("카테고리 선택>>> ");
			int pick = sc.nextInt();
			ArrayList<String> category = new ArrayList<String>();
			category.add("전자제품");
			category.add("음식");
			category.add("패션");
			category.add("취미");
			
			stmt.executeQuery("INSERT INTO GOODS VALUES((SELECT NVL(MAX(PK),0)+1 FROM GOODS),'"+name+"',"+price+","+cnt+",'"+category.get((pick-1))+"')");
			System.out.println("로그 DB연결하여 쿼리문 실행완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
