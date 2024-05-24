package camp.day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/23 18:28
 * @description:
 */
public class LE1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.next());
        twoSum(nums, target);
    }

    /**
     * 暴力解法肯定是循环两遍
     * 但是这题放在哈希表专题里，就应该哈希表也能解决
     * 用值为key，下标为value放入map
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
