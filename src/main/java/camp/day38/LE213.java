package camp.day38;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/26 9:54
 * @description:
 */
public class LE213 {
    public static void main(String[] args) {
        int rob = rob(new int[]{200, 3, 140, 20, 10});
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
    }

    public static int rob(int[] nums, int start, int end) {
        int[] dp = new int[end - start];

        dp[0] = nums[start];
        if (dp.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + 2]);
            start++;
        }

        System.out.println(Arrays.toString(dp));

        return dp[dp.length - 1];
    }

    /**
     * 方法二：直接交换
     */
    public static int rob1(int[] nums, int start, int end) {
        // x为上上层的最大值，y为上一层的最大值。
        int x = 0, y = 0;
        for (int i = start; i < end; i++) {
            int temp = Math.max(x + nums[i], y);
            x = y;
            y = temp;
        }

        return y;
    }
}
