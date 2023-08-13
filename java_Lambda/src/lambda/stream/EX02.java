package lambda.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EX02 {
    public static void main(String[] args) {
        String[] fruitArray = {"Melon", "Apple", "Banana", "Strawberry"};
        List<String> fruitList = Arrays.asList(fruitArray);

        // 원본의 데이터가 아닌 별도의 Stream 을 생성함으로
        // 원본의 데이터를 변경하지 않는다.

        Stream<String> arrayStream = Arrays.stream(fruitArray);
        // Arrays.stream : 자바에서 배열을 스트림으로 변환

        Stream<String> listStream = fruitList.stream();
        // 컬렉션의 경우 stream 메소드를 호출하여 스트림을 얻을 수 있다.

        Stream<String> sortList = listStream.sorted();

        sortList.forEach(element -> System.out.println(element));

        System.out.println();

        arrayStream.sorted().forEach(System.out::println);

    }
}
