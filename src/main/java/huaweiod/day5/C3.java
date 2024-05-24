package huaweiod.day5;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 10:55
 * @description:
 */
public class C3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int count = 0;
        for (int i = num, j = num; i >= 1 && j >= 1; ) {
            int sum = 0;
            if (i == j) {
                sum = i;
            } else {
                sum = (i + j) * (j - i + 1) / 2;
            }

            if (sum == num) {
                count++;
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    stringBuilder.append(k).append("+");
                }
                System.out.println(num + "=" + stringBuilder.substring(0, stringBuilder.length() - 1));
                i--;
            } else if (sum > num) {
                j--;
            } else if (sum < num) {
                i--;
            }
        }

        System.out.println("Result:" + count);
    }
}
