package huaweiod.day5;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 20:30
 * @description:
 * f(m) - f(m-1) >= 3
 * f(1) + f(2) + ... + f(m) = n
 */
public class C2001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] keys = in.nextLine().split(" ");
        int m = Integer.parseInt(keys[0]);
        int n = Integer.parseInt(keys[1]);
        int result = moonCake(m, n, 1);
        System.out.println(result);
    }

    /**
     * 表示 m人分n个月饼，最少每人分i个
     *
     * @param m 人
     * @param i 最少
     * @return 方法数
     */
    private static int moonCake(int m, int n, int i) {
        if (m == 1) {
            return 1;
        }
        int count = 0;
        for (int j = i; j <= n / m && j <= i + 3; j++) {
            count += moonCake(m - 1, n - j, j);
        }
        return count;
    }
}
