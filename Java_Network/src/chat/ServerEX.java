package chat;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerEX {
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        Scanner scan = new Scanner(System.in);

        try {
            server = new ServerSocket(7777);
            System.out.println("대기중");

            socket = server.accept();
            System.out.println("클라이언트 연결됨");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                String message = in.readLine();

                System.out.println("클라이언트로부터 수신 메세지: " + message);

                System.out.print("보낼 메세지: ");
                String say = scan.nextLine();
                out.write(say + "\n");
                out.flush();    // 버퍼 비우기

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
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
