package lambda;

import java.util.function.Function;

public class EX08 {
    public static void main(String[] args) {

        // Function : 함수적 인터페이스
        // 역할 : 맵핑(타입변환) 하기

        Function<String, Integer> function;
        // 첫번째 타입은 매개변수 타입, 두번째는 반환타입

        function = strNum -> Integer.parseInt(strNum);

        int number = function.apply("100");
        System.out.println(number);

        Function<Integer, Integer> square;

        square = num -> num * num;
        int result = square.apply(5);    // 5의 제곱은 : 25
        System.out.println("5의 제곱: " + result);
    }
}
