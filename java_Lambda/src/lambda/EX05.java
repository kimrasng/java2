package lambda;

@FunctionalInterface
interface Greet4 {
    
    // 4. 매개변수가 있고, 리턴값이 있는 람다식
    public String hello(String name);
    
}

public class EX05 {
    public static void main(String[] args) {

        Greet4 greet4;

        greet4 = (name) -> {
            return name + "님 안녕하세요!";
        };
        
        System.out.println(greet4.hello("김가온"));

        
        // 매개변수가 1일떄 () 생략
        // 실행코드가 return 만 있는 경우
        // 중괄호 {} 와 return 문 생략 가능
        greet4 = name -> name + "님 안녕하세요";

        System.out.println(greet4.hello("블루곤"));
        
    }
}
