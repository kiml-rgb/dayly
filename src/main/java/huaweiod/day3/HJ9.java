package huaweiod.day3;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/2 22:25
 * @description:
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围：
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            StringBuilder s = new StringBuilder();
            for (int i = next.length() - 1; i >= 0 ; i--) {
                char c = next.charAt(i);
                if (s.lastIndexOf(String.valueOf(c)) == -1) {
                    s.append(c);
                }
            }
            System.out.println(s.toString());
        }
    }
}
