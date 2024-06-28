package camp.day40;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/28 10:03
 * @description:
 */
public class LE309 {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    public static int maxProfit(int[] prices) {
        // 0 表示持有股票的状态; 1 表示不持有股票的状态
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            } else {
                // 持有：前一天持有；前一天不持有（不可能）：前两天不持有
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            }
            // 不持有：前一天不持有；前一天持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[prices.length - 1][1];
    }
}
