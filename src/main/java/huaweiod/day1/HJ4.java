package huaweiod.day1;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/3/28 21:45
 * @description:
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            StringBuilder s = new StringBuilder(scanner.nextLine());
            int length = s.length();
            int num = s.length() / 8;
            if (num * 8 < s.length()) {
                for (int i = 0; i < ((num + 1) * 8 - length); i++) {
                    s.append("0");
                }
                num++;
            }
            for (int i = 0; i < num; i++) {
                System.out.println(s.substring(i * 8, (i + 1) * 8));
            }
        }
    }
}
