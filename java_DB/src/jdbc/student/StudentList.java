package jdbc.student;

import java.sql.*;

public class StudentList {

    public static void main(String[] args) {

        Connection conn = null;
        // Connection : DB와 연결성을 갖는 객체
        Statement stmt = null;
        // Statement : DB의 데이터에 접근하여 CRUD를 처리하는 객체
        ResultSet rs = null;
        // ResultSet : 조회결과 데이터를 갖는 객체

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        try {

            String query = "SELECT * FROM STUDENT";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
            stmt = conn.createStatement();
            // createStatement 메소드를 사용하여 Statement 객체를 생성한다.

            rs = stmt.executeQuery(query);

            while(rs.next()) {
                // next : 다음 레코드가 없다면 false 반환
                // 다음 레코드가 있다면 true를 반환한 다음
                // 커서를 다음 레코드로 이동시킨다.

                int studentID = rs.getInt("STUDENTID");
                // ResultSet 의 getter 메소드를 사용하여
                // 매개값으로 컬럼이름을 문자열로 주면 해당하는 컬럼값을 얻는다.
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");
                int grade = rs.getInt("GRADE");
                int departmentCode = rs.getInt("DEPARTMENTCODE");

                System.out.println("학번 : " + studentID
                        + "\t | 이름 : " + name
                        + "\t | 나이 : " + age
                        + "\t | 학년 : " + grade
                        + "\t | 학과코드 : " + departmentCode);


            }


        }catch(Exception e) {
            e.printStackTrace();
        }finally {

            try {

                // 사용했던 객체들은 메모리에서 해제해 주어야 한다.
                // 해제하는 순서는 최근에 사용했던 객체부터
                // 거꾸로 올라가며 해제한다.
                if(rs != null)rs.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();

            }catch(Exception e2) {}

        }


    }

}
