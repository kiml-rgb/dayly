package camp.day35;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/21 9:27
 * @description:
 */
public class LE1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();


        int[] dp = new int[sum / 2 + 1];

        for (int stone : stones) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= stone) {
                    dp[j] = Math.max(dp[j], dp[j - stone] + stone);
                }
            }
        }

        return sum - dp[sum / 2] * 2;
    }
}
