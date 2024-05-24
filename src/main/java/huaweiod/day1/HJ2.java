package huaweiod.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ZYF
 * @date: 2024/3/28 20:36
 * @description:
 */
public class HJ2 {
    public static void main(String[] args) throws IOException {
        // 方法一
//        Scanner scanner = new Scanner(System.in);
//
//        String str = "";
//        String c = "";
//        if (scanner.hasNextLine()) {
//            str = scanner.nextLine();
//        }
//        if (scanner.hasNextLine()) {
//            c = scanner.nextLine();
//        }
//
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if ((Character.toString(str.charAt(i))).equalsIgnoreCase(Character.toString(c.charAt(0)))) {
//                count++;
//            }
//        }
//
//        System.out.println(count);

        // 方法二
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = bufferedReader.readLine().toLowerCase().toCharArray();
        char[] chars2 = bufferedReader.readLine().toLowerCase().toCharArray();
        int count = 0;
        for (char c : chars1) {
            if (c == chars2[0]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
