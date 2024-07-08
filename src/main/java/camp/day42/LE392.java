package camp.day42;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/7 20:58
 * @description:
 */
public class LE392 {
    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 当前指针位置相同，dp[i][j] = dp[i - 1][j - 1] + 1
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[s.length()][t.length()] == s.length();
    }
}
