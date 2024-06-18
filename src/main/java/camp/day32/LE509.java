package camp.day32;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/18 9:43
 * @description:
 */
public class LE509 {
    public static void main(String[] args) {
        int i = fibBp(0);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibBp(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

}
