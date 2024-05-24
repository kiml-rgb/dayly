package huaweiod.day4;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/4 21:36
 * @description:
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            int count = 0;
            for (int i1 = 0; i1 < num;) {
                if (num == 1) {
                    count ++;
                    break;
                }

                if (num / 2 * 2 != num) {
                    count ++;
                }
                num = num / 2;
            }

            System.out.println(count);
        }
    }
}
