package camp.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/28 17:22
 * @description:
 */
public class CM55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(rightString(k, s));
    }

    private static String rightString(int k, String s) {
        // 过界判断
        if (k >= s.length() || k <= 0) {
            return s;
        }

        return s.substring(s.length() - k) + s.substring(0, s.length() - k);
    }
}
