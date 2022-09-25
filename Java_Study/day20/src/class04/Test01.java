package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		// DBMS 선정(오라클)
		// JAVA와 연동
		// [JDBC]

		// 1. DBMS와 연동을 하기위한 드라이버가 필요
		// 1) DBMS에 해당하는 드라이버 파일을 갖고있나?
		// 2) 파일 데이터를 JAVA에 적재(load)했는가?
		// .jar의 데이터를 JAVA에 load하는 방법
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
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

			Scanner sc = new Scanner(System.in);
			System.out.println("이름입력");
			String name = sc.next();
			System.out.println("나이입력");
			int age = sc.nextInt();
			System.out.println("성적입력");
			int score = sc.nextInt();
			System.out.println("번호입력");
			String phone = sc.next();

			// stmt 객체가 확보되어야
			// JAVA에서 SQL문을 작성할수있게됨!
			stmt.executeQuery("INSERT INTO STUDENT VALUES((SELECT NVL(MAX(NUM),0)+1 FROM STUDENT),'" + name + "'," + age
					+ "," + score + ",'" + phone + "')");
			System.out.println("로그: DB연결하여 쿼리문 실행완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3. 데이터를 write,read
		// 1) connection 객체 -> conn
		// 2) stmt 객체 => read(SELECT),write(INSERT,UPDATE,DELETE)

		// 4. DB와의 연결을 해제☆
		finally {
			// 1) 연결한 순서를 생각하며 해제
			// 2) conn -> stmt -> stmt xxx -> conn xxx
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