package io.file;

import java.io.*;

public class EX06 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(dir + File.separator + "Copy.txt");

        // abcdefg

        byte[] bytesArray = new byte[5];

        while (true) {

            int count = fis.read(bytesArray);
            // 읽어온 데이터는 byte 배열에 저장된다.
            // 이떄 반환해주는 정수는
            // 몇개나 새로운 데이터를 읽었는지 count로 변환된다.

            if (count == -1) {
                break;
            }

            fos.write(bytesArray, 0, count);
            // byte 배열에 데이터를 0부터 (맨 처음부터)
            // 새로 읽어온 count 만큼만 쓴다.

        }

        fis.close();
        fos.close();

        // abcdefg
        // abcde
        // 01234


        // fgcde
        // 01234




    }
}
