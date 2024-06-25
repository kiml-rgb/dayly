package camp.day36;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/22 9:45
 * @description:
 */
public class BackpackAll {
    public static void main(String[] args) {
        integerBreak1(4, new int[][]{{1, 15}, {3, 20}, {4, 30}});
    }

    public static void integerBreak(int n, int[][] item) {
        int[][] dp = new int[item.length][n + 1];

        // 纵列初始化为0（数组定义，不用初始化）

        // 横列初始化不一样了
        for (int j = 1; j < dp[0].length && n >= item[0][0]; j++) {
            dp[0][j] = j / item[0][0] * item[0][1];
        }

        for (int i = 1; i < item.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - item[i][0] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - item[i][0]] + item[i][1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }

    public static void integerBreak1(int n, int[][] items) {
        int[] dp = new int[n + 1];
        for (int[] item : items) {
            for (int i = 0; i < dp.length; i++) {
                if (i >= item[0]) {
                    dp[i] = Math.max(dp[i], dp[i - item[0]] + item[1]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
