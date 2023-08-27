package jdbc.sungJuk;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.*;
import java.util.Scanner;

public class SungJukDAOImpl implements SungJukDAO {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbId = "C##JAVAUSER";
    String dbPw = "java123";

    Scanner input = new Scanner(System.in);


    @Override
    public void sungJukList() {
        // TODO Auto-generated method stub
        // 전체 학생의 성적을 DB에서 얻어와(select) 성적정보를 출력해주는 기능

        try {

            String query = "SELECT * FROM SUNGJUK";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {

                int code = rs.getInt("ID_CODE");
                String name = rs.getString("NAME");
                int kor = rs.getInt("KOR");
                int eng = rs.getInt("ENG");
                int math = rs.getInt("MATH");
                int total = kor + eng + math;
                int avg = total / 3;

                String.format("%.2f", avg);

                System.out.println("ID CODE : " + code
                        + "\t | 이름 : " + name
                        + "\t | 국어 : " + kor
                        + "\t | 영어 : " + eng
                        + "\t | 수학 : " + math
                        + "\t | total : " + total
                        + "\t | 평균 : " + avg);


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (stmt != null)stmt.close();
                if (conn != null)conn.close();

            } catch (Exception e2){}

        }


    }


    @Override
    public void sungJukInsert() {
        // 학생 성적 정보를 insert 하는 기능
        // 이름, 국어성적, 영어성적, 수학성적을 입력받고
        // 총점과 평균을 구하는 식을 만들어 DB의
        // SungJuk 테이블에 INSERT 하기!

        System.out.print("성적등록을 할 학생 이름 : ");
        String name = input.next();

        System.out.print("국어점수 : ");
        int kor = input.nextInt();

        System.out.print("영어점수 : ");
        int eng = input.nextInt();

        System.out.print("수학점수 : ");
        int math = input.nextInt();

        int total = kor + eng + math;
        double avg = total / 3.0;

        String strAvg = String.format("%.2f", avg);
        avg = Double.parseDouble(strAvg);

        String query = "INSERT INTO "
                + "SUNGJUK(ID_CODE, NAME, KOR, ENG, MATH, TOTAL, AVG) "
                + "VALUES(SUNGJUK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setInt(2, kor);
            pstmt.setInt(3, eng);
            pstmt.setInt(4, math);
            pstmt.setInt(5, total);
            pstmt.setDouble(6, avg);

            int result = pstmt.executeUpdate();

            if(result == 1) {
                System.out.println("학생 성적 정보가 저장되었습니다!!");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {

            try {

                if(pstmt != null)pstmt.close();
                if(conn != null)conn.close();

            }catch(Exception e2) {}

        }


    }

    @Override
    public void sungJukInfo() {
        // TODO Auto-generated method stub
        // idCode를 입력받아 DB에서 해당 학생의 성적 정보를 얻어와 출력하는 기능

        try {
            System.out.print("ID_CODE : ");
            int code = input.nextInt();

            String query = "SELECT * FROM SUNGJUK WHERE ID_CODE = ?";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, code);



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {

                if(stmt != null)stmt.close();
                if(conn != null)conn.close();

            } catch (Exception e2){}
        }

    }

    @Override
    public void sungJukUpdate() {
        // TODO Auto-generated method stub
        // idcode를 입력받고, 해당 학생의 국어 성적, 영어 성적, 수학 성적을
        // 입력받아 DB의 데이터에  UPDATE 하기


        try {
            System.out.print("ID_CODE : ");
            int code = input.nextInt();

            System.out.print("국어 : ");
            int kor = input.nextInt();
            System.out.print("영어 : ");
            int eng = input.nextInt();
            System.out.print("수학 : ");
            int math = input.nextInt();


            String query = "UPDATE SUNGJUK SET KOR = ?, ENG = ?, math = ?, TOTAL = ?, AVG = ?  WHERE ID_CODE = ?";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            pstmt = conn.prepareStatement(query);

            // PreparedStatement 의 setter 메소드로 ?의 데이터를 넣을 수 있다.
            pstmt.setInt(1, kor);
            // 첫번째 인자는 ?의 인덱스를 넣어준다. ?의 인덱스는 1부터 시작한다.
            pstmt.setInt(2, eng);
            pstmt.setInt(3, math);
            pstmt.setInt(4, kor + eng + math);
            pstmt.setInt(5, (kor + eng + math) / 3);
            pstmt.setInt(6, code);

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

    @Override
    public void sungJukDelete() {
        // TODO Auto-generated method stub
        // idcode를 입력받아 해당학생 삭제하기

        try {
            System.out.print("삭제할 ID_CODE : ");
            int code = input.nextInt();

            String query = "DELETE FROM SUNGJUK WHERE ID_CODE = ?";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);

            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, code);

            int result = pstmt.executeUpdate();

            if(result == 1) {
                System.out.println("delet 성공!!");
            }

        }catch(Exception e) {
            System.out.println("delt 실패!!");
            e.printStackTrace();
        }finally {

            try {

                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch(Exception e2) {}

        }


    }

}
