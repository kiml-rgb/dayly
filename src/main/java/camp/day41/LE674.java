package camp.day41;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/2 16:37
 * @description:
 */
public class LE674 {
    public static void main(String[] args) {
        int lengthOfLCIS = findLengthOfLCIS(new int[]{2, 2, 2, 2, 2});
        System.out.println(lengthOfLCIS);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
