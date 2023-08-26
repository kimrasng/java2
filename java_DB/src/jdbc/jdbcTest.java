package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcTest {

    public static void main(String[] args) {

        Connection conn = null;
        // DB와 연결성을 갖는 객체

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            System.out.println("Connection 성공!!");

        }catch(Exception e) {
            System.out.println("Connection 실패!!");

            e.printStackTrace();
        }finally {
            try {
                if(conn != null) conn.close();
            }catch(Exception e2) {}
        }


    }

}
