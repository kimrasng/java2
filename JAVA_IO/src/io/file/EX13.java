package io.file;

import java.io.*;

public class EX13 {
    public static void main(String[] args) {

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectOutputStream ois = new ObjectOutputStream(bis);

        SungJuk sj = (SungJuk)ois.readObject();

        System.out.println("이름 : " + sj.name);
        System.out.println("성정 : " + sj.score);

    }
}
