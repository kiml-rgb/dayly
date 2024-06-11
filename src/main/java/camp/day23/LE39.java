package camp.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/11 9:05
 * @description:
 */
public class LE39 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(ints, 7);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i -> i).toArray()));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 要剪枝必须要排序
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();

        combinationSumBFS(0, 0, target, candidates, resultOne, result);
        return result;
    }


    private static void combinationSumBFS(int startIndex, int sum, int target, int[] candidates, List<Integer> resultOne, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(resultOne));
            return;
        }

        // for循环的判断做了剪枝优化处理
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            resultOne.add(candidates[i]);
            combinationSumBFS(i, sum + candidates[i], target, candidates, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
        }
    }
}
