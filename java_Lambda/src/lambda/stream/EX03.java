package lambda.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX03 {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> numbers = Arrays.asList(array);

        Stream<Integer> numberStream = numbers.stream();

        Stream<Integer> numberFilter = numberStream.filter(num -> num % 2 == 0);
        // filter 메소드를 사용해서 짝수인지 확인하는 조건을 걸어서
        // 새로운 스트림을 생성한다.

        List<Integer> numberList = numberFilter.collect(Collectors.toList());
        // Collect 메소드를 사용하여 필터링된 요소들을 수집후
        // Collectors.toList() : 수집한 요소들을 List 타입으로 반환한다.


        // 원본
        System.out.println("원래 number" + numbers);

        // 변환
        System.out.println("짝수 출력 : " + numberList);





    }

}
