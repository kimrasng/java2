package thread;

// 멀티스레드의 경우 여러스레드가 객체를 공유해서 작업을 하면 서로 작업에
// 영향을 주게된다. 이러한 일이 발생하지 않도록 한 스레드가 작업을 마치기 전까지
// 다른스레드의 방해받지 않도록 하는것이 필요하다.
// 한 스레드가 진행중인 작업을 다른 스레드가 간섭하지 못하게 하는 것을
// 스레드의 동기화 (synchronization) 라고 한다.

class RentalCar {

    private String carName;

    public synchronized void getRentalCar(String carName) {

        // synchronized 를 붙이면 메소드가 호출된 시점부터 해당 메소드가
        // 포함된 객체의 락을 얻어 작업을 수행하다가 메소드가 종료되면 락을 반환
        
        System.out.println();
        System.out.println("렌터가 조회를 합니다 ~~");
        searchTime();
        this.carName = carName;
        System.out.println("렌터카가 있습니다~!!");
        System.out.println("빌릴차 : " + this.carName);

    }

    public void searchTime() {

        for (int i = 0; i < 1000000; i ++) {
            if (i == 500000) {
                System.out.println("조회중 입니다~ 잠시만요~!");
            }
        }

    }

}

class Person extends Thread {

    String carName;
    RentalCar rentalCar;

    public Person(String carName, RentalCar rentalCar) {
        this.carName = carName;
        this.rentalCar = rentalCar;
    }

    @Override
    public void run() {
        rentalCar.getRentalCar(carName);
    }
}





public class EX09 {
    public static void main(String[] args) {
        RentalCar rentalCar = new RentalCar();

        Person person1 = new Person("소나타", rentalCar);
        Person person2 = new Person("그랜져", rentalCar);
        Person person3 = new Person("람보르기니", rentalCar);
        Person person4 = new Person("K5", rentalCar);

        person1.start();
        person2.start();
        person3.start();
        person4.start();

    }
}
