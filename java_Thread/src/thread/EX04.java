package thread;

public class EX04 {
    public static void main(String[] args) {
        
        // Runnable 인터페이스의 익명 클래스(객체) 생성하기
        Runnable run = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }

        };

        Thread thread = new Thread(run);
        // Thread 클래스로부터 객체생성을 할떄 익명객체를 넣어준다.

        thread.setName("나의 세번쨰 스레드");

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main 스레드");
        }

    }
}
