package thread;

class A {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

// 2. Runnable 인터페이스를 상속받은 클래스를 구현하여 작업스레드 구현
class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class EX03 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();

        Thread thread = new Thread(myThread);
        // Thread 클래스의 객체를 생성할때 생성자에
        // Runnable 인터페이스를 상속받은 객체를 넣어서 스레드 구현

        thread.setName("나의 두번째 스레드");

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main 스레드");
        }

        System.out.println("main 메소드 끝");

    }
}
