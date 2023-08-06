package io.file;

import java.io.*;
import java.util.TreeMap;

public class EX02 {
    public static void main(String[] args) throws Exception{
        File dir = new File("C:"+ File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        if (file.createNewFile()) {
            // createNewFile : 파일이 없으면 파일이 생성후 true 반환
            //                 파일이 없으면 false 반환

            System.out.println("aaaa.txt 파일을 생성했습니다.");

        } else {
            System.out.println("aaaa.txt 파일은 이미 존재합니다.");
        }

        File imsi = File.createTempFile("java", ".dat", dir);
        // 임시파일 생성
        // 임시파일은 앞에 이름을 정하고(접두사) 중간에 임의의 숫자가 들어간다.
        // 뒤에 이름을 정한다. (접미사) [보통은 확장자]

        // 출력 : java.data


        // file == aaaa.txt
        // imsi == java????.data


        imsi.deleteOnExit();
        // 프로그램 종료시 삭제.

        Thread.sleep(5000);
        // 5초간(5000ms) 프로그램을 잠재움


        file.delete();
        // 바로 삭제

        Thread.sleep(5000);



    }
}
