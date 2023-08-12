package thread;

import java.util.Scanner;

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(1000);
                // sleep 메소드는 지정된 시간동은 스레드를 일시정지 상태로 만든다.
            } catch (InterruptedException e) {}

            System.out.println(i);
        }
    }
}

public class EX06 {
    public static void main(String[] args) {

        // 두 Thread가 서롣 다른 작업을 하는 경우 멀티쓰레드가 효율적이다.
        // 사용자의 입력을 받는작업을 하는 경우 입력을 기다리는 동안
        // 다른 쓰레드에서 다른 작업을 할 수 있다.


        MyThread3 thread = new MyThread3();

        thread.start();

        Scanner scan = new Scanner(System.in);

        System.out.println("문자열을 입력해주세요 : ");

        String str = scan.nextLine();

        System.out.println("입력하신 문자열은 : " + str + "입니다.0");

        scan.close();

    }
}





