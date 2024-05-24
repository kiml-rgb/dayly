package camp.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/24 15:18
 * @description:
 */
public class LE454 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums1 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int[] nums3 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int[] nums4 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-i - j, 0);
            }
        }

        return res;
    }
}
