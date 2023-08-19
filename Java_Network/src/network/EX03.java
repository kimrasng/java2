package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EX03 {
    public static void main(String[] args) throws IOException {

        // URLConection 클래스는 URL을 사용하여
        // 실제 네트워크 연결을 생성하고 데이터를 읽거나
        // 사요할 수 있는 기능을 제공한다.


        try {

            URL url = new URL("https://www.naver.com/");

            URLConnection connection = url.openConnection();
            // URL 객체의 openConnection 메소드를 호출하여
            // 해당 URL에 대한 연결(Connection) 객체를 생성

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // connection.getInputStream : 연결 객체로부터 입력 스트립을 얻는다.
            // InputStreamReader : 바이트 스트림을 문자스트림으로 변환해주는 역할
            // BufferedReader : 문자 스트림을 한 줄씩 읽어오기 위해 사용

            String line = null;

            while ((line = br.readLine()) != null ) {
                System.out.println(line);
            }

            br.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
