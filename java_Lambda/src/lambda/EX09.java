package lambda;

import java.util.function.BinaryOperator;

public class EX09 {
    public static void main(String[] args) {
        
        // Operator : 함수적 인터페이스
        // 역할 : 매개값 개산하여 반환하기
        BinaryOperator<Integer> operator;

        operator = (num1, num2) -> Math.max(num1, num2);

        int max = operator.apply(10, 20);
        System.out.println("최대 값 : " + max);

        operator = Math::min;   // (num1, num2) -> Math.,ain(num1, num2);
        // 이중 콜론 연산자는 람다식에서 파라미터를 중복해서 사용하고 싶지 않을때 사용한다.
        // [인스턴스]::[메소드명 (or new)]
        // 람다 표현식에서만 사용가능하고
        // static 메소드인 경우 인스턴스 대신에 클래스명으로 사용할 수 있다.

        int min = operator.apply(10,20);
        System.out.println("최소값 : " + min);









        
    }
}
