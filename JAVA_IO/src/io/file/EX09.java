package io.file;

import java.io.*;
import java.nio.Buffer;

public class EX09 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println("안녕하세요");
        pw.println(20);
        pw.println(3.14);
        pw.println("좋은 주말 되세요~!!!!!");

        pw.close();

    }
}
