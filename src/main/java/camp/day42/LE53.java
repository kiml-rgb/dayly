package camp.day42;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/7 20:38
 * @description:
 */
public class LE53 {
    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        return max;
    }
}
