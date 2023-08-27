package jdbc.sungJuk;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.util.Scanner;

public class SungJukMain {
    public static void main(String[] args) {

        SungJukDAO dao = new SungJukDAOImpl();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("###################################");
            System.out.println("## 1. 학생성적 목록 2. 학생성적 조회 ##");
            System.out.println("## 3. 학생성적 등록 4. 학생성적 수정 ##");
            System.out.println("## 5. 학생성적 삭제 6. 학생성적 종료 ##");
            System.out.println("###################################");
            System.out.println("");
            System.out.print("선택 : ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    dao.sungJukList();
                    break;
                case 2:
                    dao.sungJukInfo();
                    break;
                case 3:
                    dao.sungJukInsert();
                    break;
                case 4:
                    dao.sungJukUpdate();
                    break;
                case 5:
                    dao.sungJukDelete();
                    break;
                case 6:
                    System.out.println("성적 프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못 입력 하였습니다.");
            }


        }

    }
}
