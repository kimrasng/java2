package practice;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.util.*;

public class EX04 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("국어", 87);
        map.put("영어", 0);
        map.put("수학", 94);
        map.put("JAVA", 100);

        System.out.println(map.toString());

        int kor = map.get("국어");

        System.out.println("국어의 점수 : " + kor);

        // 객체를 하나씩 처리

        Set<String> keySet = map.keySet();

        Iterator<String> keyIter = keySet.iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();

            int value = map.get(key);

            System.out.println("key : " + key + ", value : " + value);
        }

    }
}
