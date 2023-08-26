package jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentUpdate {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        // PreparedStatement : Statement 의 기능향상
        // 컴파일시에 sql 구문이 결정되므로 구문이 변경될 수 없다.
        // 데이터가 들어갈 자리에 ?를 지정함으로 가독성이 향상된다.

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        try {

            String query = "UPDATE STUDENT SET AGE = ?, GRADE = ?, DEPARTMENTCODE = ? WHERE STUDENTID = ?";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            pstmt = conn.prepareStatement(query);

            // PreparedStatement 의 setter 메소드로 ?의 데이터를 넣을 수 있다.
            pstmt.setInt(1, 23);
            // 첫번째 인자는 ?의 인덱스를 넣어준다. ?의 인덱스는 1부터 시작한다.
            pstmt.setInt(2, 4);
            pstmt.setInt(3, 111);
            pstmt.setInt(4, 202312);

            int result = pstmt.executeUpdate();
            // executeUpdate : 결과는 레코드의 수

            if(result == 1) {
                System.out.println("UPDATE 성공!!");
            }

        }catch(Exception e) {
            System.out.println("UPDATE 실패!!");
            e.printStackTrace();
        }finally {

            try {

                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch(Exception e2) {}

        }


    }

}





