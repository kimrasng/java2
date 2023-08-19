package chat;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientEX {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        Scanner scan = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 7777);
            System.out.println("서버에 연결 됨");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                System.out.print("보낼 메세지: ");
                String say = scan.nextLine();
                out.write(say + "\n");
                out.flush();    // 버퍼 비우기

                String message = in.readLine();
                if (message != null) {
                    System.out.println("서버 수신 메세지: " + message);
                }

                if (say.equalsIgnoreCase("exit")) {
                    System.out.println("채팅 종료");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
