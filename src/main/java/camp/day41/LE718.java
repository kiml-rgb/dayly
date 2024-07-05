package camp.day41;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/2 19:40
 * @description:
 */
public class LE718 {

    public static void main(String[] args) {
        int length = findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int maxLength = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }

        return maxLength;
    }
}
