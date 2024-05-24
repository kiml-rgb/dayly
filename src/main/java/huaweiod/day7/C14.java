package huaweiod.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/9 21:41
 * @description:
 */
public class C14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int result = i;

        for (int k = 1; k <= i; k++) {
            if ((k + "").contains("4")) {
                result--;
            }
        }

        System.out.println(result);
    }
}
