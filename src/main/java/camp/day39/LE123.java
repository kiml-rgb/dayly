package camp.day39;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/27 10:34
 * @description:
 */
public class LE123 {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{1,2,3,4,5});
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        // `dp[i][0]` 表示第 i 天第一次持有股票所得最多现金，`dp[i][1]` 表示第 i 天第一次不持有股票所得最多现金，`dp[i][2]` 表示第 i 天第二次持有股票所得最多现金，`dp[i][2]` 表示第 i 天第二次不持有股票所得最多现金
        int[][] dp = new int[prices.length][4];

        // 初始化
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 1. 求 dp[i][0]: 前一天也持有就为 dp[i - 1][0]，前一天不持有就为 -prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 2. 求 dp[i][1]: 前一天也不持有就为 dp[i - 1][1]，前一天持有就为 dp[i - 1][0] + prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // 3. 求 dp[i][2]: 前一天也持有为 dp[i - 1][2]，前一天不持有就为 dp[i - 1][1] - prices[i]
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // 4. 求 dp[i][3]: 前一天也不持有为 dp[i - 1][3]，前一天持有就为 dp[i - 1][2] + prices[i]
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[prices.length - 1][3];
    }
}
