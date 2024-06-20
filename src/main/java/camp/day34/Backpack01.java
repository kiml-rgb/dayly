package camp.day34;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/20 9:43
 * @description:
 */
public class Backpack01 {
    public static void main(String[] args) {
        integerBreak1(4, new int[][]{{1, 15}, {3, 20}, {4, 30}});
    }

    /**
     * 二维数组解法
     * @param n 背包大小
     * @param item 物品及重量及价值
     */
    public static void integerBreak(int n, int[][] item) {
        int[][] dp = new int[item.length][n + 1];

        for (int i = 1; i < dp[0].length && n >= item[0][0]; i++) {
            dp[0][i] = item[0][1];
        }

        for (int i = 1; i < item.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - item[i][0] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }

    /**
     * 一维数组解法
     * @param n 背包大小
     * @param item 物品及重量及价值
     */
    public static void integerBreak1(int n, int[][] item) {
        int[] dp = new int[n + 1];

        for (int[] ints : item) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j - ints[0] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - ints[0]] + ints[1]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
