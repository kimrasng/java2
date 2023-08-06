package io.file;

import java.io.*;

public class EX03 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileOutputStream fos = new FileOutputStream(file, true);
        // 파일이 없으면 만든다.
        // 객체생성시 true 이면 이어쓰기, false이면 다시쓰기 default가 false

        // fos.write(65);
        // 아스키 코드로 넣어준다.
        // fos.write('B');

        String msg = "Hello World!!!";

        byte[] byteArray = msg.getBytes();

        fos.write(byteArray, 6, 5);

        fos.close();


    }
}
