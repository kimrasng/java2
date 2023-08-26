package jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentInsert {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        try {

            String query = "INSERT INTO STUDENT "
                    + "VALUES(202310, '블루곤', 22, 3, 333)";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
            stmt = conn.createStatement();

            int result = stmt.executeUpdate(query);
            // executeUpdate 는 변경된 레코드의 수

            if(result == 1) {
                System.out.println("INSERT 성공");
            }


        }catch(Exception e) {
            System.out.println("INSERT 실패");
            e.printStackTrace();

        }finally {

            try {

                if(stmt != null)stmt.close();
                if(conn != null)conn.close();

            }catch(Exception e2) {}

        }

    }

}





