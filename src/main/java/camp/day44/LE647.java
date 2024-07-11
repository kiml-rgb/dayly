package camp.day44;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/9 18:44
 * @description:
 */
public class LE647 {
    public static void main(String[] args) {
        countSubstrings("aaa");
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    num++;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return num;
    }
}
