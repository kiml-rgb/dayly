package huaweiod.day5;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 16:56
 * @description:
 */
public class C7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            if (isSuShu(num)) {
                System.out.println("-1 -1");
            }

            int i = 2;
            for (; i < num / 2; i++) {
                if (num % i == 0 && isSuShu(i) && isSuShu(num / i)) {
                    System.out.println(i + " " + num / i);
                    break;
                }
            }

            if (i == num / 2) {
                System.out.println("-1 -1");
            }
        }
    }

    /**
     * 是否是素数
     * @param num 输入
     */
    private static Boolean isSuShu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
