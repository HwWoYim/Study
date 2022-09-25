package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Test02_1 {
   public static void main(String[] args) {

      // JDBC 4단계
      
      final String driverName="oracle.jdbc.driver.OracleDriver";
      final String url="jdbc:oracle:thin:@localhost:1521:xe";
      final String user="yim";
      final String password="1234";
      
      Connection conn=null;
      Statement stmt=null;
      try {
         Class.forName(driverName);
         
         conn=DriverManager.getConnection(url, user, password);
         stmt=conn.createStatement();
         
         String name="컴퓨터";
         int price=1234123;
         int cnt=10;
         ArrayList<String> category=new ArrayList<String>();
         category.add("전자제품");
         category.add("음료");
         category.add("빵");
         category.add("책");
         category.add("신발");
         int num=1;
         String sql="INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'"+name+"',"+price+","+cnt+",'"+category.get(num-1)+"')";
         stmt.executeQuery(sql);
         
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