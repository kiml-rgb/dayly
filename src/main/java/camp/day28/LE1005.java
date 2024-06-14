package camp.day28;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/14 10:41
 * @description:
 */
public class LE1005 {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{-2,5,0,2,-2}, 3));
    }

    /**
     * 思路：可以多次选择同一个数字，返回最大和，说明可以先排序
     * 1. 从小到大排列， 把所有负数变正
     * 2. 还有次数剩余。奇数次剩余，就把绝对值最小的翻转一次。
     *
     * @param nums 数组
     * @param k 翻转次数
     * @return 结果
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (Math.abs(nums[i]) < minAbs) {
                minAbs = Math.min(minAbs, Math.abs(nums[i]));
                index = i;
            }

            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }

        if (k % 2 == 1) {
            sum -= 2 * nums[index];
        }

        return sum;
    }
}
