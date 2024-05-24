package huaweiod.day8;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/10 22:37
 * @description:
 */
public class C19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();

        int count = 0;
        for (char c : charArray) {
            if ("o".equals(String.valueOf(c))) {
                count++;
            }
        }

        if (count % 2 == 1) {
            System.out.println(charArray.length - 1);
        } else {
            System.out.println(charArray.length);
        }
    }
}
