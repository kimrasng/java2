package thread;

class EatThread extends Thread {
    @Override
    public void run() {

        try {

            while (!isInterrupted()) {
                // inInterrupted : 현재 스레드가 인터럽트 요청을 받았는지 확인

                // !는 논리 부정연산자
                // interrupt 메소드가 호출 되었다면 true 가 되어져서
                // while문을 종료
                
                System.out.println("계속 먹는 중....");
                Thread.sleep(1000);

            }

        }catch (InterruptedException e) {
            System.out.println("그만 먹는다.!!!");
        }
        System.out.println("종료!");
    }
}

public class EX08 {
    public static void main(String[] args) throws Exception{

        EatThread thread = new EatThread();

        thread.start();

        Thread.sleep(5000);

        thread.interrupt();
        // 스레드가 일시정지 상태에 있을때 이 스레드에 대해
        // 스레드를 꺠워서 실행대기 상태로 만든다.
    }
}
