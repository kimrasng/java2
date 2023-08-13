package lambda.stream;

import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX04 {
    public static void main(String[] args) {

        // map 메소드는 스트림의 각 요소를 변환하여 새로운 스트림을 생성하는데 사용

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


        // 각 숫자에 2를 곱한 값을 계산 후 새로운 리스트를 생성
        Stream<Integer> numberStream = numbers.stream().map(num -> num * 2);

        List<Integer> newNumbers = numberStream.collect(Collectors.toList());

        System.out.println("원래 숫자 : " + numbers);
        System.out.println("2를 곱한 결과 : " + newNumbers);


    }
}
