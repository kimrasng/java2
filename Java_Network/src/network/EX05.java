package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EX05 {
    public static void main(String[] args) {

        Socket socket = null;
        //
        BufferedWriter bw = null;

        try {

            socket = new Socket("localhost", 12345);

            System.out.println("서버에 연결 되었습니다.....");

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            bw.write("Hello server!");

            bw.flush();
            // flush 메소드로 버퍼를 비워내고 데이터를 전송한다

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
