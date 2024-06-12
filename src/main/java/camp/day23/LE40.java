package camp.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/11 9:44
 * @description:
 */
public class LE40 {
    public static void main(String[] args) {
        int[] ints = {2,5,2,1,2};
        List<List<Integer>> result = combinationSum2(ints, 5);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i -> i).toArray()));
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();

        combinationSum2DFS(0, 0, target, candidates, resultOne, result);
        return result;
    }

    /**
     * 思路：
     * 1. 和上题差不多。但是数组变成有重复元素的了。
     * 2. 想法是每层遍历的时候，去重
     */
    private static void combinationSum2DFS(int startIndex, int sum, int target, int[] candidates, List<Integer> resultOne, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(resultOne));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i - 1 >= startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            resultOne.add(candidates[i]);
            combinationSum2DFS(i + 1, sum + candidates[i], target, candidates, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
        }
    }
}
