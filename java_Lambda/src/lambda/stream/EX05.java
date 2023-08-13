package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX05 {
    public static void main(String[] args) {

        // distinct : 스트림에서 중복된 요소를 제거하는 중간 연산이다.

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5, 6, 7);

        Stream<Integer> distinctNumber = numbers.stream().distinct();
        // distinct 메소드를 호출하면 중복된 요소가 제거되고, 새로운 스트림이 변환된다.

        List<Integer> distinctNumbers = distinctNumber.collect(Collectors.toList());

        System.out.println("원래 숫자 : " + numbers);
        System.out.println("중복 제거 숫자" + distinctNumbers);

    }
}
