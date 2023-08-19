package network;

import java.net.*;

public class EX01 {
    public static void main(String[] args) {

        // InetAddress 클래스는 호스트명과 IP 주소 간의 변환 및
        // Network 연결 시 IP 주소 해결에 사용됩니다.

        try {
            InetAddress address = InetAddress.getByName("www.daum.net");
            // InetAddress 클래스의 정적 메소드인 getByName은
            // 도메인명(host)을 통해 해당 Network 정보를 얻어오는 역할을 합니다

            System.out.println("Host name : " + address.getHostName());
            System.out.println("IP : " + address.getHostAddress());
            // getHostName : Host 이름 반환
            // getHostAddress : 해당 Host IP 주소 반환

            System.out.println();

            InetAddress localhost = InetAddress.getLocalHost();
            // getLocalHost : 현재 실행중인 컴퓨터인 로컬호스트에 대한
            // InetAddress 객체를 얻어온다.

            System.out.println("Local host name : " + localhost.getHostName());
            System.out.println("Local ip : " + localhost.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
