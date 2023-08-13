package lambda;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class EX07 {
    public static void main(String[] args) {

        // Supplier : 함수적 인터페이스
        // 역할 : 생산자. 매개값이 없고, 리턴값이 있다.
        // 매개변수를 받지 않고 값을 반환하는 메소드를 반환하는데 사용한다.

        Supplier<String> supplier = () -> "나는 김레생 입니다.";

        String str = supplier.get();
        System.out.println(str);
        
        // Supplier 인터페이스를 사용하여
        // 1부터 100까지 정수 중 하나를 반환하는 람다식 구현

//        int a = (int)(Math.random() * 10) + 1;  // 1 ~ 10
        // 0.0부터 1.0미만의 double 타입의 수 하나를 반환
//        System.out.println(a);

        Supplier<Integer> randomSupplier;

        randomSupplier = () -> ((int)(Math.random() * 100)) + 1;

        System.out.println("1부터 100까지 정수중 하나 얻기 : " + randomSupplier.get());







    }
}
