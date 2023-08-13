package lambda;

import java.util.function.IntPredicate;

public class EX10 {
    public static void main(String[] args) {

        // Predicate : 함수적 인터페이스
        // 역할 : 매개값 확인하여 booled값 (true / false) 값 반환
        // IntPreadicate : int 값을 조사

        IntPredicate intPredicate;

        intPredicate = num -> num >= 80;

        boolean result = intPredicate.test(100);

        if (result == true) {
            System.out.println("합격 입니다.");
        } else {
            System.out.println("불합격 입니다.");
        }


    }
}
