package thread;

public class EX01 {
    public static void main(String[] args) {

        // main 메소드의 작업을 수행하는 것도 스레드이며
        // 이름 main 스레드라고 한다.

        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("반갑습니다.");
        }


    }
}
