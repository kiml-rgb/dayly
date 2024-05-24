package huaweiod.day3;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/2 22:49
 * @description:
 *
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder result = new StringBuilder();
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            for (int i = s.length() - 1; i >= 0 ; i--) {
                result.append(s.charAt(i));
            }
        }
        System.out.println(result);
    }
}
