package camp.day32;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/18 10:24
 * @description:
 */
public class LE746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(cost);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        System.out.println(Arrays.toString(dp));

        return dp[cost.length];
    }
}
