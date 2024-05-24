package camp.day2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/18 23:21
 * @description:
 */
public class LE209 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        int[] nums = Arrays.stream(s.substring(1, s.length() - 1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        for (int i = 0, j = 0; i < nums.length && j < nums.length; ) {
            int subArraySum = getSum(nums, i, j);
            if (target == subArraySum) {
                min = Math.min(min, j - i + 1);
                i++;
                j = i;
                if (min == 1) {
                    break;
                }
            } else if (target < subArraySum) {
                i++;
                j = i;
            } else {
                j++;
            }
        }
        return min;
    }

    private static int getSum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
