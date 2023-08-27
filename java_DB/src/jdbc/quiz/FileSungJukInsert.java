package jdbc.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileSungJukInsert {

    public static void main(String[] args) throws Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "C##JAVAUSER";
        String dbPw = "java123";

        File file = new File("C:\\aaa\\sungJuk.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String query = "INSERT INTO "
                + "SUNGJUK(ID_CODE, NAME, KOR, ENG, MATH, TOTAL, AVG) "
                + "VALUES(SUNGJUK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        String name = null;
        int kor = 0;
        int eng = 0;
        int math = 0;
        int total = 0;
        double avg = 0.0;

        try {

            String str = null;

            if((str = br.readLine()) != null) {

                String[] array = str.split(":");

                List<String> list = Arrays.asList(array);

                Iterator<String> iter = list.iterator();

                if(iter.hasNext()) {
                    name = iter.next();
                }else {
                    return;
                }

                if(iter.hasNext()) {
                    kor = Integer.parseInt(iter.next());
                }else {
                    return;
                }

                if(iter.hasNext()) {
                    eng = Integer.parseInt(iter.next());
                }else {
                    return;
                }

                if(iter.hasNext()) {
                    math = Integer.parseInt(iter.next());
                }else {
                    return;
                }

                total = kor + eng + math;

                avg = total / 3.0;

                avg = Double.parseDouble(String.format("%.2f", avg));

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
                    System.out.println("파일의 학생정보를 DB에 저장했습니다.");
                }



            }else {
                System.out.println("읽어올 데이터가 없습니다.");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {

            try {

                if(br != null)br.close();
                if(rs != null)rs.close();
                if(pstmt != null)pstmt.close();
                if(conn != null)conn.close();

            }catch(Exception e2) {}

        }




    }

}
