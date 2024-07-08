package camp.day42;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/5 15:23
 * @description:
 */
public class LE1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("xaxx", "a"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];


        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // 当前指针位置相同，dp[i][j] = dp[i - 1][j - 1] + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
//                    if (i == 0 || j == 0) {
//                        dp[i][j] = 0;
//                        continue;
//                    } else if (i == 0) {
//                        dp[i][j] = dp[0][j - 1];
//                        maxLength = Math.max(dp[i][j], maxLength);
//                        continue;
//                    } else if (j == 0) {
//                        dp[i][j] = dp[i - 1][0];
//                        maxLength = Math.max(dp[i][j], maxLength);
//                        continue;
//                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[text1.length()][text2.length()];
    }
}
