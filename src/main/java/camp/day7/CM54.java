package camp.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/28 9:52
 * @description:
 */
public class CM54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(replaceNumber(scanner.nextLine()));
    }

    public static String replaceNumber(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ('0' <= c && '9' >= c) {
                stringBuilder.append("number");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
