package lambda;

@FunctionalInterface
interface Greet3 {
    // 3. 매개변수가 없고, 리턴값이 있는 람다식
    public String hello(); // The return type should be specified here
}

public class EX04 {
    public static void main(String[] args) {

        Greet3 greet3;

        greet3 = () -> {
            return "김가온님 안녕하세요";
        };

        System.out.println(greet3.hello()); // You should call the hello() method of greet3

        // 실행코드가 return 문만 사용하는 경우에
        // 중괄호와 return문 생략 가능하다.

        greet3 = () -> "블루곤님 안녕하세요";

        System.out.println(greet3.hello());

    }
}





