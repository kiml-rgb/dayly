package camp.day33;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/19 10:15
 * @description:
 */
public class LE343 {
    public static void main(String[] args) {
        int i = integerBreak(10);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                // 并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                // j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }
}
