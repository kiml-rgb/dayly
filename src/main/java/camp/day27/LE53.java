package camp.day27;

/**
 * @author ZYF
 * @date: 2024/6/13 10:51
 * @description:
 */
public class LE53 {
    // 思路是连续和为负，就直接抛弃连续和
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
