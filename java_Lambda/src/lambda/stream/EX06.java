package lambda.stream;

import java.util.Arrays;
import java.util.List;

public class EX06 {

    public static void main(String[] args) {

        // Stream 의 reduce 메소드는 스트림 요소를 조합하여
        // 하나의 결과를 도출하는 작업을 수행

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 스트림 요소의 합 구하기
        int sum = numbers.stream().reduce(0, (acc, number) -> acc + number);

        // reduce 메소드의 첫번째 매개변수는 초기값이며,
        // 두번째 매개변수는 이진연산 이다.
        // (acc, number) -> acc + number 는
        // 현재까지의 누적 합을 acc 에 누적하고
        // 요소를 number로 받아서 더한 결과를 반환하는 역할을 한다.

        System.out.println("요소의 합 : " + sum);


    }

}
