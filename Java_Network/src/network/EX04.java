package network;

import java.net.*;
import java.io.*;

public class EX04 {

    public static void main(String[] args) {


        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader br = null;

        try {

            serverSocket = new ServerSocket(12345);
            // ServerSocket 클래스는 서버 역할을 하는 소켓을 생성하고
            // 클라이언트의 연결을 수락하기 위해 사용되는 클래스이다.
            // 서버소켓 생성 및 포트번호(12345)를 사용하여 연결 대기

            System.out.println("서버 대기 중....");

            clientSocket = serverSocket.accept();
            // ServerSocket 의 accept 메소드를 사용하여
            // 클라이언트의 연결을 수락할 수 있다.
            // 클라이언트의 연결을 수락하여 실제 통신을 위한 소켓객체를 생성한다.

            System.out.println("클라이언트 연결됨.");

            // 클라이언트로부터 데이터 받기

            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = br.readLine();

            System.out.println("클라이언트로부터 수신 메세지 : " + message);


        }catch(Exception e) {
            e.printStackTrace();

        }finally { // 스트림 닫기

            try {
                br.close();
                clientSocket.close();
                serverSocket.close();
            }catch(Exception e2) {}
        }


    }

}
