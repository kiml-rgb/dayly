package camp.day43;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/8 17:01
 * @description:
 */
public class LE115 {
    public static void main(String[] args) {
        int i = numDistinct("baegg", "bag");
        System.out.println(i);
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 当前指针位置相同，dp[i][j] = dp[i - 1][j - 1] + 1
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[s.length()][t.length()];
    }
}
