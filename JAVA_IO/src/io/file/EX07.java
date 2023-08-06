package io.file;

import java.io.*;

public class EX07 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 버퍼에 담는다. (성능 향상)

        DataOutputStream dos = new DataOutputStream(bos);
        // 원하는 데이터 형태로 저장한다. (기능 향상)

        int a = 100;
        double b = 3.14;
        String c = "Hello, World";

        dos.writeInt(a);
        dos.writeDouble(b);
        dos.writeUTF(c);

        dos.close();
    }
}
