package thread;

// 1. Thread 클래스를 상속하여 작업 스레드 구현
class MyThread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            // Tread 이름 얻기 : getName 메소드 호출
            System.out.println(this.getName());

        }

    }
}


public class EX02 {
    public static void main(String[] args) {

        MyThread1 thread = new MyThread1();

        System.out.println(thread.getName());

        thread.setName("나의 첫번째 스레드");
        // 스레드 이름 바꾸기 : setName("이름")

        System.out.println(thread.getName());

        System.out.println("--------------------------------------");

//        thread.run();

        thread.start();
        // 스레드의 start 메소드를 호출하게 되면
        // run 메소드가 호출되면서 독립적인 호출스텍이 생성되고
        // 스레드가 종료되면 작업에 사용된 호출스택을 소면된다.

        for (int i = 0; i < 100; i++) {
            System.out.println("메인 스레드");
        }

        thread.start();
        // 한번 실행이 종료된 스레드는 다시 실행할 수 없다.
        // 만약 스레드의 작업을 한번더 수행해야 한다면
        // 새로운 스레드를 생성한 다음 start 메소드를 호출해야한다.


    }
}
