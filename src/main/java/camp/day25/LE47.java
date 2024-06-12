package camp.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/12 9:28
 * @description: https://leetcode.cn/problems/permutations-ii
 */
public class LE47 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        List<List<Integer>> permuteUnique = permuteUnique(ints);
        for (List<Integer> list : permuteUnique) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i -> i).toArray()));
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();


        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        permuteUniqueDFS(nums, new boolean[]{}, resultOne, result);
        return result;
    }

    /**
     * 用数组标记因为这个树更像一个矩阵
     * 数组可以标记nums又可以标记层数
     */
    private static void permuteUniqueDFS(int[] nums, boolean[] used, List<Integer> resultOne, List<List<Integer>> result) {
        if (resultOne.size() == nums.length) {
            result.add(new ArrayList<>(resultOne));
            return;
        }

        // set记录下标
        for (int i = 0; i < nums.length; i++) {
            // 记录了index值，即这index被使用了（这里可以理解）
            if (used[i]) {
                continue;
            }

            // 如果这个数值和前面的数值相同
            // 首先一定要排序，这样nums数组中的前面一个节点，就一定是被用过了
            // 然后现在到这个节点，前面一个节点的状态是false(这里横向看)，说明已经回溯了。节点已经被添加，跳过这层
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 这层是否使用过
            used[i] = true;
            resultOne.add(nums[i]);
            permuteUniqueDFS(nums, used, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
            used[i] = false;
        }
    }
}
