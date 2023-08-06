package io.file;

import java.io.*;

public class EX11 {
    public static void main(String[] args) throws Exception{

        File dir = new File("c:" + File.separator + "aaaa");
        File file = new File(dir, "ox.txt");

        // OX 퀴즈
        // 1000개의 OX들이 있다.
        // O는 1점 X는 점수가 없다.
        // 만약 연속으로 O가 등장할경우 점수가 2배

        // -------- 예시 --------
        // OOXXXXOO (1+2+1+2) 6점
        // OOOOXOOO ( 1+2+4+8+1+2+4) 22점
        // 1000 개의 OX 점수합을 구하세요

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        int totalScore = 0; // 총 점수의 합을 구할 변수
        int score = 0;

        // 'O' == 79

        while (true) {

            String ox = br.readLine();

            if (ox == null) {
                break;
            }

            System.out.println(ox);

            char[] charArray = ox.toCharArray();
            // 문자열을 한글자씩 char배열로 변환

            byte[] bytesArray = ox.getBytes();

            score = 1;  // 점수는 1로 초기화

            for (int i = 0; i < bytesArray.length; i++) {

                if (bytesArray[i] == 'O') {

                    totalScore += score;
                    score *= 2; // score = score *2

                }else {
                    score = 1;
                }

            }
        }
        System.out.println("총 OX 점수의 합 : " + totalScore);

        br.close();
        fr.close();
    }
}
