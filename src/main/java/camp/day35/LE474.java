package camp.day35;

/**
 * @author ZYF
 * @date: 2024/6/21 11:32
 * @description:
 */
public class LE474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // 这里x计算0的数量， y计算1的数量
        int x, y;
        for (String str : strs) {
            x = 0;
            y = 0;
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (c == '0') {
                    x++;
                } else {
                    y++;
                }
            }

            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= x && j >= y) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - x][j - y] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
