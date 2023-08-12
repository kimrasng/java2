package thread;

// Thread 클래스를 상속받는 Food 클래스를 만들어
// run 메소드 재정의하기 >> 반복문으로 음식을 먹습니다. << 100번 출력

class Food implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("음식을 먹습니다.");
        }
    }
}

// Thread 클래스를 상속받는 Music 클래스를 만들어
// run 메소드 재정의하기 >> 음악을 재생합니다. << 100번 출력

class Music implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("음악을 재생합니다.");
        }
    }
}

public class EX05 {
    public static void main(String[] args) {

        System.out.println("!!!MAIN시작!!!");

        Food food = new Food();
        Music music = new Music();

        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        // 스레드에 우선순위를 지정해서 실행제어를 할 수 있다.
        // 정수로 표현하며, 가장 높은 우선순위를 10, 가장 낮은 우선순위를 1이며
        // 기본값은 5이다, 우선순위가 높을수록 더 많은 시간을 확보할 수 있다.

        Thread foodThread = new Thread(food);
        Thread musicThread = new Thread(music);

        foodThread.setPriority(Thread.MAX_PRIORITY);
        musicThread.setPriority(Thread.MIN_PRIORITY);

        foodThread.start();
        musicThread.start();

        try {
            foodThread.join();  // main 스레드가 food의 작업이 끝날때까지 기다린다.
            musicThread.join(); // main 스레드가 music의 작업이 끝날때까지 기다린다.
        } catch (InterruptedException e){}

        System.out.println("!!MAIN종료!");

    }
}
