package lambda.practice;

interface Profile1 {
    public void profile();
}

interface Profile2 {
    public void profile(String name);
}

interface Profile3 {
    public String profile();
}

interface Profile4 {
    public String profile(String name);
}



public class EX01 {
    public static void main(String[] args) {
    
        // Profile1 ~ Profile4 인터페이스의
        // Profile 무명메소드 람다식으로 구현



        // profile1
        Profile1 profile1;

        profile1 = () -> {
            System.out.println("김가온님 반가워요!");
        };

        profile1.profile();



        // profile2
        Profile2 profile2;

        profile2 = (name) -> {
            System.out.println(name + "님 반가워요!");
        };
        
        profile2.profile("블루곤");


        // profile3
        Profile3 profile3;

        profile3 = () -> {
            return "이은교님 반가워요!";
        };

        System.out.println(profile3.profile());



        // profile4
        Profile4 profile4;

        profile4 = (name) -> {
            return name + "님 반가워요!";
        };

        System.out.println(profile4.profile("조현규"));

    }
}
