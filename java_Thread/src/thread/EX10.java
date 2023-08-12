package thread;

// BankAccount 클래스를 만든다.
// 필드는 private int totalMoney; 이다.
// 생성자에서 매개변수로 필드 초기화를한다.
// 정상(입금금액) 하나를 매개변수로 받아
// totalMoney에 더해주는 depoit 메소드를 만든다.
// 메소드는 동기화가 될 수 있도록 하고 입금금액과 총 잔액을 출력해준다.
// 필드값을 얻을 수 있도록 getter 메소드를 만든다.


class BankAccount {
    private int totalMoney;

    public BankAccount(int initialMoney) {
        totalMoney = initialMoney;
    }

    public synchronized void deposit(int money) {

        totalMoney += money;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("입금 금액 : " + money + " | 총 잔액 : " + totalMoney);

    }

    public int getTotalMoney() {
        return totalMoney;
    }

}


public class EX10 {
    public static void main(String[] args) {

        // BankAccount 클래스로부터 객체생성 후
        // Runnable 의 익명클래스를 만들어서 run 메소드를 오버라이딩 한 후
        // BankAccount 객체의 deposit 메소드를 호출하도록 한다.
        // Runnable 익명객체를 생성자의 매개값으로 받는
        // Thread 객체 2객를 생성 후 start 메소드 호출하기

        BankAccount account = new BankAccount(1000);

        Runnable run = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    account.deposit(100);
                }

            }
        };

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종 잔액 : " + account.getTotalMoney());

    }
}
