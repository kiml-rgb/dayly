package camp.day39;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/27 9:17
 * @description:
 */
public class LE121 {
    public static void main(String[] args) {
        int i = maxProfit2(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        // `dp[i][0]` 表示第 i 天持有股票所得最多现金，`dp[i][1]` 表示第 i 天不持有股票所得最多现金。
        int[][] dp = new int[prices.length][2];

        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 1. 求 dp[i][0]: 前一天也持有就为 dp[i - 1][0]，前一天不持有就为 -prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 2. 求 dp[i][1]: 前一天也不持有就为 dp[i - 1][1]，前一天持有就为 dp[i - 1][0] + prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[prices.length - 1][1];
    }

    /**
     * 贪心解法
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
