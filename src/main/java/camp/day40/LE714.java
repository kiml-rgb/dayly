package camp.day40;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/28 11:07
 * @description:
 */
public class LE714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];

        // 假设买入的时候支付手续费
        dp[0][0] = -prices[0] - fee;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[prices.length - 1][1];
    }
}
