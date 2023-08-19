package network;

import java.net.*;

public class EX02 {
    public static void main(String[] args) {

        // URL 클래스는 네트워크 리소스에 접근하고
        // 데이터를 읽거나 사용할 수 있는 기능을 제공하는 클래스

        try {

            URL url = new URL("https://www.naver.com/");

            System.out.println("protocol : " + url.getProtocol());
            System.out.println("HOST : " + url.getHost());
            System.out.println("Port : " + url.getPort());
            System.out.println("Path : " + url.getPath());

            // path EX) naver.com/blog
            // path == blog


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
