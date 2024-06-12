package camp.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/11 15:18
 * @description:
 */
public class LE78 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2};
        List<List<Integer>> list = subsets(ints);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.stream().mapToInt(i -> i).toArray()));
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        subsetsDFS(0, nums, resultOne, result);
        return result;
    }

    /**
     * 这个和之前的区别在于，如果转化成一颗树。之前只要求叶子节点。这个全部都要
     * 而且还要不重复
     * @param startIndex 起始index
     */
    private static void subsetsDFS(int startIndex, int[] nums, List<Integer> resultOne, List<List<Integer>> result) {
        result.add(new ArrayList<>(resultOne));

        for (int i = startIndex; i < nums.length; i++) {
            if (i - 1 >= startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            resultOne.add(nums[i]);
            subsetsDFS(i + 1, nums, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
        }
    }
}
