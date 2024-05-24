package camp.day5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/23 16:20
 * @description:
 */
public class LE349 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums1 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int[] intersection = intersection(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                intersection.add(i);
            }
        }

        return intersection.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();
    }
}
