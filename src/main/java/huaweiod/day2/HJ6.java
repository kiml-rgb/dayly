package huaweiod.day2;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/3/30 14:37
 * @description: 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            if (nextInt < 1) {
                System.out.println("0");
                continue;
            }
            if (nextInt == 1 || nextInt == 2 || nextInt == 3) {
                System.out.println(nextInt);
                continue;
            }

            for (int i = 2; i <= Math.sqrt(nextInt) + 1; ) {
                int divResult = Math.floorDiv(nextInt, i);
                if (divResult * i == nextInt) {
                    nextInt = divResult;
                    System.out.print(i + " ");
                } else {
                    i++;
                }
            }

            System.out.println(nextInt);
        }
    }

}
