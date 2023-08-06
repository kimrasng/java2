package io.file;

import java.io.*;

public class EX05 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "test.png");

        // 파일 복사
        FileInputStream fis = new FileInputStream(file);

        FileOutputStream fos = new FileOutputStream(dir + File.separator + "copy.png");

        while (true) {

            int data = fis.read();

            if (data == -1 ) {
                break;
            }

            fos.write(data);

        }

        fos.close();
        fis.close();

    }
}
