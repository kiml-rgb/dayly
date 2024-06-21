package camp.day35;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/21 10:19
 * @description:
 */
public class LE494 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 1, 1};
        findTargetSumWays(ints,3);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) {
            return 0;
        }

        if (sum < Math.abs(target)) {
            return 0;
        }

        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = dp.length - 1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[left];
    }
}