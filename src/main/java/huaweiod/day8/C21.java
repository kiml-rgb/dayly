package huaweiod.day8;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/10 22:54
 * @description:
 */
public class C21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num <= 2) {
            System.out.println("N");
        }

        int count = 0;
        int x = 0;
        int y = 0;
        for (int i = 2; i <= (int) Math.sqrt(num * 2); i++) {
            System.out.println(i);
            int n = num * 2 / i;
            if (n * i == num * 2 && (i + n - 1) % 2 == 0 && (n - i + 1) % 2 == 0) {
                y = (i + n - 1) / 2;
                x = (n - i + 1) / 2;
                count++;
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num).append("=");
        if (count > 0) {
            for (int j = x; j <= y; j++) {
                stringBuilder.append(j).append("+");
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
        } else {
            System.out.println("N");
        }
    }
}
