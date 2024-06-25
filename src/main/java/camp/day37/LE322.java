package camp.day37;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/25 9:14
 * @description:
 */
public class LE322 {
    public static void main(String[] args) {
        coinChange(new int[]{2}, 3);
    }

    /**
     * 思路：
     * 1. 硬币获取可以重复（完全背包）
     * 2. 组合问题。先循环coins
     * @param coins 硬币数组
     * @param amount 数量
     * @return 结果
     */
    public static int coinChange(int[] coins, int amount) {
        // dp 表示凑成金额所需要的最小个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                if(dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i- coin] + 1);
                }
             }
        }

        System.out.println(Arrays.toString(dp));

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
