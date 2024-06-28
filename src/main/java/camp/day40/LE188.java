package camp.day40;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/28 9:16
 * @description:
 */
public class LE188 {
    public static void main(String[] args) {
        maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
    }


    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];

        // 初始化数据
        for (int i = 0; i < k; i++) {
            dp[0][i * 2] = -prices[0];
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            for (int j = 1; j < 2 * k; j++) {
                if (j % 2 == 0) {
                    // 偶数买入
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    // 奇数卖出
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[prices.length - 1][2 * k - 1];
    }
}
