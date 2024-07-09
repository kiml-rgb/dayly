package camp.day43;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/8 18:38
 * @description:
 */
public class LE583 {
    public static void main(String[] args) {
        int i = minDistance("sea", "eat");
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 当前指针位置相同，dp[i][j] = dp[i - 1][j - 1] + 1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[word1.length()][word2.length()];
    }
}
