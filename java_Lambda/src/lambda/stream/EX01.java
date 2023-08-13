package lambda.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EX01 {
    public static void main(String[] args) {
        String[] fruitArray = {"Melon", "Apple", "Banana", "Strawberry"};

        // Arrays.asList : 주어진 배열을 리스트로 변환하는데 사용하는 메소드
        // 배열을 수정하지 않고 배열의 요소들을 리스트 형태로 다룰 수 있다.

        List<String> fruitList = Arrays.asList(fruitArray);

        // 원본의 데이터가 직접 정렬 된다.
        Arrays.sort(fruitArray);

        Collections.sort(fruitList);
        // Collections.sort 는 주어진 컬렉션을 정렬하는 데 사용된다.
        // 이 메소드는 List 인터페이스를 구현한 컬렉션들을 정렬하는데 사용된다.

        for (String str : fruitArray) {
            System.out.println(str);
        }

        System.out.println("------------------------");

        for (String str : fruitArray) {
            System.out.println(str);
        }
    }
}
