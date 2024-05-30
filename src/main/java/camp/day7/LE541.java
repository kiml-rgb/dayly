package camp.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/27 9:48
 * @description:
 */
public class LE541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverseStr(scanner.nextLine(), Integer.parseInt(scanner.nextLine())));
    }

    /**
     * 画图翻译了一下
     * 大概意思就是奇数段反转
     */
    public static String reverseStr(String s, int k) {
        // 判断能拆分成几段
        int size = s.length() / k;
        if (s.length() % k != 0) {
            size = size + 1;
        }

        StringBuilder reverseStr = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            String substring = s.substring((i - 1) * k, Math.min(i * k, s.length()));
            if (i % 2 != 0) {
                char[] chars = substring.toCharArray();
                for (int n = 0, m = chars.length - 1; n <= m; n++, m--) {
                    char temp = chars[n];
                    chars[n] = chars[m];
                    chars[m] = temp;
                }
                reverseStr.append(chars);
            } else {
                reverseStr.append(substring);
            }
        }

        return reverseStr.toString();
    }
}




