package camp.day41;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/1 11:09
 * @description:
 */
public class LE300 {
    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{0});
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
