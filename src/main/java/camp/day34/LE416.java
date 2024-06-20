package camp.day34;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/20 10:40
 * @description:
 */
public class LE416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int[] dp = new int[sum / 2 + 1];

        for (int num : nums) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j - num >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
            if (dp[sum / 2] == sum / 2) {
                return true;
            }
        }
        return false;
    }
}
