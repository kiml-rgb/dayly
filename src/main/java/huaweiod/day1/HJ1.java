package huaweiod.day1;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/3/28 20:16
 * @description:
 */
public class HJ1 {
    public static void main(String[] args) throws IOException {
        // 方法一
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String next = in.nextLine();
            if (null == next || next.length() == 0) {
                System.out.println("0");
                return;
            }
            if (next.lastIndexOf(" ") == -1) {
                System.out.println(next.length());
                return;
            }
            System.out.println(next.substring(next.lastIndexOf(" ") + 1).length());
        }

        // 方法二
//        InputStream inputStream = System.in;
//        int length = 0;
//        char c;
//        while ('\n' != (c = (char) inputStream.read())) {
//            length++;
//            if (c == ' ') {
//                length = 0;
//            }
//        }
//        System.out.println(length);
    }
}
