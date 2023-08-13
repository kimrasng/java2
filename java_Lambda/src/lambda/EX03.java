package lambda;

interface Greet2 {
    // 2. 매개변수가 있고, 리턴값이 없는 람다식
    public void hello(String name);
    
}

public class EX03 {
    public static void main(String[] args) {

        Greet2 greet2;

        // 매개변수의 타입은 실행시 대입되는 값에 따라 자동으로 인식될 수 있다.
        // 따라서 매개변수의 타입은 일반적으로 생략하고 사용한다.

        greet2 = (/*String*/ name) -> {
            System.out.println((name + "님 안녕하세요"));
        };

        greet2.hello("김가온");

        // 중괄호 {} 를 생략하고 한줄에 작성
        greet2 = (name) -> System.out.println(name + "님 안녕하세요");
        
        greet2.hello("블루곤");

        // 매개변수가 단 1개 있을경우 소괄호를 제거할 수 있다.
        // 단, 매개변수가 없다면 소괄호를 반드시 붙여주어야 한다.
        greet2 = name -> System.out.println(name + "님 안녕하세요");

        greet2.hello("이은교");


    }
}

