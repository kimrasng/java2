package practice;

import java.util.*;

public class EX05 {
    public static void main(String[] args) {
        
        // HashMap을 사영하여 아이디, 비밀번호 3개 저장하기
        // <String, String>
        // keyset 메소드로 key 목록을 Set 타입으로 반환 받은 후
        // Iterator를 사용하여 아이디, 비밀번호 출력하기

        Map<String, String> map = new HashMap<>();

        map.put("larang", "1234");
        map.put("noobnuby", "1111");
        map.put("devproje", "2222");

        Set<String> keySet = map.keySet();

        Iterator<String> keyIter = keySet.iterator();

        while (keyIter.hasNext()) {

            String id = keyIter.next();

            String pw = map.get(id);

            System.out.println("ID : " + id + "PS : " + pw);

        }

    }
}
