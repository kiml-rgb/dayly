package camp.day1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/17 22:23
 * @description:
 */
public class LE704 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scanner.nextLine());
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int k = (i + j) / 2;
            if (nums[k] == target) {
                return k;
            }
            if (nums[k] > target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }

        return -1;
    }
}
