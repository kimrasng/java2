package thread;

// 데몬쓰레드는 일반쓰레드의 작업을 돕는 보조적인 역할을 하는 쓰레드이다.
// 일반쓰레드가 모두 종료되면 데몬쓰레드는 강제적으로 자동 동료된다.
// 데몬쓰레드는 무한루프와 조건문을 이용해서 대기하고 있다가 특정조건이
// 만족되면 작업을 수행하고 다시 대기하도록 작성한다.

class MyDaemon extends Thread {
    public int playTime;

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // 1초
        } catch(InterruptedException e) {}
        if(playTime == 60) {
            System.out.println("게임한지 1시간 넘었으니 그만해!");
        }
        if(playTime == 100) {
            System.out.println("게임 그만하고 저녁식사 외식하러 가자!");
        }
    }
}

public class EX07 {
    public static void main(String[] args) throws Exception{

        MyDaemon daemon = new MyDaemon();

        daemon.setDaemon(true); // 데몬스레드 지정

        daemon.start();

        for (int i = 10; i <= 110; i += 10) {

            Thread.sleep(1000);
            System.out.println(i + "분동안 게임중...");

            if (i==60) {
                daemon.playTime = 60;
            }

            if (i == 100) {
                daemon.playTime = 100;
            }

        }
        System.out.println("게임을 종료합니다.");

    }
}
