package camp.day36;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/22 11:10
 * @description:
 */
public class LE518 {
    public static void main(String[] args) {
        change(5, new int[]{1,2,5});
    }

    /**
     * 思路：
     * 1. 这是一个完全背包的题目（正序）
     * 2. 求的是组合数量 dp[i] += dp[i - coin];
     * @param amount 总数
     * @param coins 硬币总和
     * @return 有几种组合方法
     */
    public static int change(int amount, int[] coins) {
        // 填满 i（包括 i）这么大容积的包，有 `dp[i]` 种方法
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[amount];
    }
}
