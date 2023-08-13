package lambda;

import java.util.ArrayList;
import java.util.List;

public class EX11 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("사과");
        list.add("딸기");
        list.add("바나나");
        list.add("수박");
        list.add("포도");

        // foEach 메소드는 자바 컬렉션의 요소들을 반복하며
        // 각 요소들에 대해 지정된 동작을 수행할 수 있는 메소드이다.
        // 함수형 프로그래밍 스타일을 지원하여
        // 코드를 더 간결하게 작성할 수 있게 해준다.

        list.forEach(fruit -> {
            System.out.println(fruit);
        });

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        
        // forEach 메소드와 람다식을 사용하여
        // numbers 의 수 중에 홀수만 출력해보기

        numbers.forEach(num -> {
            if (num % 2 == 1) {
                System.out.println(num);
            }
        });

    }
}
