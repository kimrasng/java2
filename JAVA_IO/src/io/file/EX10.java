package io.file;

import java.io.*;

public class EX10 {
    public static void main(String[] args) throws Exception {

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while (true) {

            String msg = br.readLine();

            if (msg == null) {
                // text에서 파일 끝값은 null이다.
                break;
            }

            System.out.println(msg);

        }

        br.close();

    }
}
