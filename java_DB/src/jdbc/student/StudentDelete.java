package jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDelete {

    public static void main(String[] args) {

        // Scanner 로 학번을 입력받아서 
        // Student 테이블에 해당 학생을 삭제하기

        Connection conn = null;
        PreparedStatement pstmt = null;

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        Scanner scan = new Scanner(System.in);

        try {

            String query = "DELETE FROM STUDENT WHERE STUDENTID = ?";

            System.out.print("삭제할 학생의 학번 입력 : ");
            int studentID = scan.nextInt();

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, studentID);

            int result = pstmt.executeUpdate();

            if(result == 1) {
                System.out.println("DELETE 성공!!");
            }


        }catch(Exception e) {
            System.out.println("DELET 실패");
            e.printStackTrace();
        }finally {

            try {

                if (pstmt != null) pstmt.close();
                if (conn != null) pstmt.close();

            } catch (Exception e2) {}

        }


    }

}
