package com.yim.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	// JDBCUtil
	//  => ctrl+C,ctrl+V
	//      : �ڵ� ����, �ߺ��ڵ� �ּ�ȭ, ���ȭ, UtilŬ���� ����!
	// Util�� Ŭ����
	//  : static
	static final String driverName="oracle.jdbc.driver.OracleDriver";
	static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	static final String user="yim";
	static final String passwd="1234";
	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName(driverName);

			conn=DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
