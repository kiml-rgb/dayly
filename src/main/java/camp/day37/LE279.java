package camp.day37;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/25 10:08
 * @description:
 */
public class LE279 {
    public static void main(String[] args) {
        numSquares(13);
    }

    /**
     * 思路：背包大小为n，从1-根号n之间取数
     * 1. 数可以重复取值，完全背包
     * 2. 排列顺序不统计，组合问题
     *
     * @param n 和为n
     * @return 结果
     */
    public static int numSquares(int n) {
        // dp[i] 表示和为n的完全平方数的最小数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);

        dp[0] = 0;
        int num = (int) Math.sqrt(n);
        for (int i = 1; i <= num; i++) {
            for (int j = i * i; j < dp.length; j++) {
                if (dp[j - i * i] != n + 1) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
