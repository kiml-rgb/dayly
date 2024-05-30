package camp.day6;

import org.omg.CORBA.MARSHAL;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/5/24 16:24
 * @description:
 */
public class LE15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(",")).filter(Objects::nonNull).mapToInt(Integer::parseInt).toArray();
        threeSum(num);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            /**
             * 只能是与前一个比较进行去重
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    /**
                     * 去重逻辑应该放在找到一个三元组之后
                     * 否则获取不到结果集
                     */
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    /**
     * 思路：关键在于，这题不要求输出下标。
     * 所以可以先排序再求值
     * @param nums nums
     * @return 结果
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        ArrayList<List<Integer>> list = new ArrayList<>();
        // 递增序列，前三位和大于0，直接返回
        if (nums[0] + nums[1] + nums[2] > 0) {
            return list;
        }

        int i = 0;
        int j = i + 1;
        int k = nums.length - 1;
        while (i < j && j < k) {
            System.out.println(i + " " + j + " " + k);
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
            } else if (sum < 0) {
                j++;
            } else {
                k--;
            }
            while (j > i + 1 && j <= nums.length - 1 && nums[j] == nums[j - 1]) {
                j++;
            }
            while (k > j && k != nums.length - 1 && nums[k] == nums[k + 1]) {
                k--;
            }
            if (j >= k) {
                i = i + 1;
                while (i != 0 && i <= nums.length - 1 && nums[i] == nums[i - 1]) {
                    i++;
                }
                j = i + 1;
                k = nums.length - 1;
            }
        }
        return list;
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        // 判断是否重复
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort(Integer::compareTo);
                        map.put(list.stream().map(integer -> integer + "").collect(Collectors.joining(",")), list);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            list.add(stringListEntry.getValue());
        }
        return list;
    }
}
