package io.file;

import java.io.*;

public class EX01 {

    public static void main(String[] args) throws Exception{
        File file1 = new File("C:\\aaaa\\aaaa.text");
        // 파일이 없어도 상관 없다.

        File file2 = new File("C:\\aaaa", "aaaa.txt");
        // 파일경로와 파일명으로 객체를 생성할 수 있다.

        File file3 = new File("C:\\aaaa");
        // 파일경로까지만 지정하여 객체생성을 할 수 있다.

        File file4 = new File(file3, "aaaa.txt");
        // 파일 경로의 객체를 넣어서 객체생성을 할 수 있다.

        // windows 폴더 구별자 : \
        // Linux 폴더 구별자 : /

        // File.separator : 폴더 구별자

        File dir = new File("C:"+ File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");


    }

}
