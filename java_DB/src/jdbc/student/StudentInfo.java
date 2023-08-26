package jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInfo {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        Scanner scan = new Scanner(System.in);

        try {

            System.out.print("조회할 학생의 학번 입력 : ");
            int studentID = scan.nextInt();

            String query = "SELECT * FROM STUDENT "
                    + "WHERE STUDENTID = " + studentID;

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

            if(rs.next()) {

                studentID = rs.getInt("STUDENTID");
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");
                int grade = rs.getInt("GRADE");
                int departmentCode = rs.getInt("DEPARTMENTCODE");

                System.out.println(name + " 학생의 학번 : " + studentID);
                System.out.println(name + " 학생의 나이 : " + age);
                System.out.println(name + " 학생의 학년 : " + grade);
                System.out.println(name + " 학생의 학과코드 : " + departmentCode);

            }else {
                System.out.println(studentID + " 학번의 학생은 존재하지 않습니다.");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {

            try {

                if(rs != null)rs.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();

            }catch(Exception e2) {}

        }



    }

}
