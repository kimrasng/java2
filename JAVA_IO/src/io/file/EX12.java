package io.file;

import java.io.*;

class SungJuk implements Serializable {


}

public class EX12 {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:" + File.separator + "aaaa");
        File file = new File(dir, "aaaa.txt");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        // 객체 입출력 스트림 사용이유
        // 복잡한 데이터 구조를 저장할 수 있고 객체를 직렬화하여 상태를 저장하면,
        // 프로그램이 종료되거나 중단된 상황에서도 이전 상태를 보전할 수 있다.
        // 또한 직렬화된 객체는 일반 텍스트보다 더욱 어렵게 이해할 수 있으므로,
        // 데이터 보안 측면에서도 유리하다.

        SungJuk sj = new SungJuk();

        oos.writeObject(sj);

        oos.writeObject(sj);

        oos.close();

    }
}
