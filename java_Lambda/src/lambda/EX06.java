package lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class EX06 {
    public static void main(String[] args) {

        // Consumer 함수적 인터페이스
        // 역할 : 소비자. 매개값이 있고, 리턴값은 없다.

        Consumer<String> consumer = str -> {
          System.out.println("입력 문자열 : " + str);
        };
        consumer.accept("오늘 좋은주말 되세요~!!");

        String[] words = {"apple", "banana", "cherry"};

        // Consumer를 사용하여 각 요소를 대문자로 출력해보기
        Consumer<String[]> upperCaseConsumer = strArray -> {

            for (String str : strArray) {
                System.out.println(str.toUpperCase());
            }

        };

        upperCaseConsumer.accept(words);

    }
}
