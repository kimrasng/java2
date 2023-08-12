package lambda;

interface MyInterface {

    public void print();

}

class MyClass implements MyInterface {
    @Override
    public void print() {
        System.out.println("Hello World");
    }
}

public class EX01 {
    public static void main(String[] args) {

        // 인터페이스를 구현한 구현클래스
        MyClass myclass = new MyClass();
        myclass.print();

        // 익명클래스

        MyInterface myInterface = new MyInterface() {
            @Override
            public void print() {
                System.out.println("익명클래스 입니다.");
            }
        };

        myInterface.print();

        // 람다식이란 하나의 식으로 표현한 것이다.
        // 함수를 람다식으로 표현하면 메소드의 이름이 필요없기 때문에
        // 람다식은 익명함수의 한 종류라고 볼 수 있다.

        MyInterface in = () -> {
            System.out.println("람다식 입니다.");
        };

        in.print();

    }
}
