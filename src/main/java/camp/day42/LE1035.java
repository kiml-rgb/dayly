package camp.day42;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/7 15:47
 * @description:
 */
public class LE1035 {
    public static void main(String[] args) {
        maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1});
    }
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // 当前位置加入计数
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[nums1.length][nums2.length];
    }
}
