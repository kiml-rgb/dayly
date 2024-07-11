package camp.day44;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/10 15:43
 * @description:
 */
public class LE516 {
    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        int max= 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return max;
    }
}
