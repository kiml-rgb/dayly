package camp.day33;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/19 9:15
 * @description:
 */
public class LE62 {
    public static void main(String[] args) {
        uniquePaths(3, 2);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        if (m <= 1 || n <= 1) {
            return 1;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
