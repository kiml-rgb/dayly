package camp.day2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/18 22:49
 * @description:
 */
public class LE977 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] nums = Arrays.stream(s.substring(1, s.length() - 1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int[] ints = new int[nums.length];

        while (i <= j) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];
            ints[k] = Math.max(i2, j2);
            k--;
            if (i2 >= j2) {
                i++;
            } else {
                j--;
            }
        }

        return ints;
    }
}
