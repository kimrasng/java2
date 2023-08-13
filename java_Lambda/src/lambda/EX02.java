package lambda;

// 어노테이션이란 메타코드(정보)라고 불 수 있다.
// 소스코드에 @를 주석처럼 달아 특정한 기능을 실행하도록 정보제공

// 람다식으로 구현할 수 있는 인터페이스는
// 하나의 추상메소드를 포함하는 함수형 인터페이스만 가능하다.
// 따라서 함수형 인터페이스를 작성할 떄
// 두 개 이상의 추상메소드가 선언되는 오류를 방지하고
// @Functionalinterface 언어테이션을 사용할 수 있다.


@FunctionalInterface
interface Greet {
    // 1. 매개변수가 없고 반환값이 없는 경우
    public void hello();

    // public void hello2();
    // 메소드를 여러개 생성시 오류
    
}

public class EX02 {
    public static void main(String[] args) {

        // 인터페이스 변수선언
        Greet greet;

        greet = () -> {
          System.out.println("안녕하세요!!");
        };

        greet.hello();

        // 중괄호 {} 안에 실행문이 하나밖에 없다면, 중괄호 제거가 가능하다.
        greet = () -> System.out.println("안녕하세요~~");

        greet.hello();
        
    }
}
