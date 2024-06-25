package camp.day36;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/22 11:26
 * @description:
 */
public class LE377 {
    public static void main(String[] args) {
        int i = combinationSum4(new int[]{1, 2, 3}, 4);
    }

    /**
     * 完全背包+组合
     *
     * @param nums   数组
     * @param target 总数
     * @return 有几种组合
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[target];
    }
}
