package io.file;

import java.io.*;

public class EX04 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileInputStream fis = new FileInputStream(file);

        while (true) {

            int data = fis.read();
            // 한글자 한글자 아스키 코드로 받는다

            if (data == -1) {
                // 바이트 입력에 파일 끝 값은 -1이다.
                break;
            }

            System.out.print((char)data);

        }

        fis.close();
    }
}
